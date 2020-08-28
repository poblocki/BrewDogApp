package com.poblocki.brewdogapp.data.repository

import android.util.Log
import androidx.paging.PagedList
import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.domain.model.Beer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class BeerBoundaryCallback @Inject constructor(
	private val beerLocalDataSource: BeerLocalDataSource,
	private val beerRemoteDataSource: BeerRemoteDataSource,
	private val appSchedulers: AppSchedulers
) : PagedList.BoundaryCallback<Beer>() {

	private var disposable: Disposable? = null
	private val subscriptions = CompositeDisposable()
	private var pageToRequest = 1
	private var canProcessRequest = true

	override fun onZeroItemsLoaded() {
		Log.e("$this", "onZeroItemsLoaded")
		requestAndSaveData()
	}

	override fun onItemAtEndLoaded(itemAtEnd: Beer) {
		Log.e("$this", "onItemAtEndLoaded $itemAtEnd")
		requestAndSaveData()
	}

	override fun onItemAtFrontLoaded(itemAtFront: Beer) {}

	fun endBeersSubscription() {
		subscriptions.clear()
	}

	private fun requestAndSaveData() {
		if (canProcessRequest.not()) return
		disposable = beerRemoteDataSource.getFromApi(pageToRequest, NETWORK_PAGE_SIZE)
			.flatMap(beerLocalDataSource::insertToDatabase)
			.doOnSubscribe { subscriptions.add(it) }
			.doOnSubscribe { canProcessRequest = false }
			.observeOn(appSchedulers.diskIO)
			.subscribe(
				{ list ->
					if (list.isNotEmpty()) {
						pageToRequest += 1
						canProcessRequest = true
					} else {
						canProcessRequest = false
					}
				},
				{ throwable ->
					Log.e("$this", "Error ${throwable.message}")
					canProcessRequest = true
				}
			)
	}

	companion object {
		private const val NETWORK_PAGE_SIZE = 20
	}
}