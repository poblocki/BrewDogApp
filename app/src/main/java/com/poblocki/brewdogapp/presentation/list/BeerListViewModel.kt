package com.poblocki.brewdogapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.usecase.GetBeersUseCase
import io.reactivex.Flowable
import javax.inject.Inject

class BeerListViewModel @Inject constructor(private val getBeersUseCase: GetBeersUseCase) :
	ViewModel() {

	companion object {
		const val page = 15
	}

	val beerList: LiveData<PagedList<Beer>> =
		LiveDataReactiveStreams.fromPublisher(
			getBeersUseCase.getBeersByPage(page).onErrorResumeNext(Flowable.empty())
		)

	override fun onCleared() {
		getBeersUseCase.endBeersSubscription()
		super.onCleared()
	}
}