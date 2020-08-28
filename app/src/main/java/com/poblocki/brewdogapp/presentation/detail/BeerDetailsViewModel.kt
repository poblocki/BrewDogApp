package com.poblocki.brewdogapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.domain.usecase.ShowBeerDetailsUseCase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class BeerDetailsViewModel @Inject constructor(
	private val showBeerDetailsUseCase: ShowBeerDetailsUseCase,
	private val appSchedulers: AppSchedulers,
	private val beerDetailsMapper: BeerDetailsMapper
) : ViewModel() {

	private val compositeDisposable = CompositeDisposable()
	private var disposable: Disposable? = null

	private val _beerDetails = MutableLiveData<BeerDetails>()
	val beerDetails: LiveData<BeerDetails> = _beerDetails

	fun getBeerDetails(id: Long) {
		disposable?.dispose()
		disposable = showBeerDetailsUseCase.showBeerDetails(id)
			.map(beerDetailsMapper::toDetails)
			.observeOn(appSchedulers.mainThread)
			.subscribe(
				{ _beerDetails.value = it },
				{ Log.e("$this", "Error ${it.message}") }
			)
		compositeDisposable.addAll(disposable)
	}

	override fun onCleared() {
		compositeDisposable.clear()
		super.onCleared()
	}
}