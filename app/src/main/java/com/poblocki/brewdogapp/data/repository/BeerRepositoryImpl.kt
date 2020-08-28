package com.poblocki.brewdogapp.data.repository

import android.util.Log
import androidx.paging.PagedList
import androidx.paging.toFlowable
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.repository.BeerRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class BeerRepositoryImpl @Inject constructor(
	private val beerLocalDataSource: BeerLocalDataSource,
	private val beerBoundaryCallback: BeerBoundaryCallback
) : BeerRepository {

	override fun showBeerDetails(id: Long): Single<Beer> = beerLocalDataSource.getBeerById(id)

	override fun endBeersSubscription() = beerBoundaryCallback.endBeersSubscription()

	override fun getBeersByPage(pageSize: Int): Flowable<PagedList<Beer>> =
		beerLocalDataSource.getBeersWithPaging()
			.toFlowable(pageSize, boundaryCallback = beerBoundaryCallback)
			.doOnError { Log.e("$this", "Error ${it.message}") }
			.onErrorResumeNext(Flowable.empty())
}