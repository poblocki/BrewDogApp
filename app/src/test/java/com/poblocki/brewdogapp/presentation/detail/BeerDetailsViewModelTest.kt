package com.poblocki.brewdogapp.presentation.detail

import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.common.scheduler.TestSchedulers
import com.poblocki.brewdogapp.domain.usecase.ShowBeerDetailsUseCase
import io.mockk.mockk
import org.junit.Test

class BeerDetailsViewModelTest {

	private val showBeerDetailsUseCase: ShowBeerDetailsUseCase = mockk()
	private val appSchedulers: AppSchedulers =
		TestSchedulers()
	private val beerDetailsMapper: BeerDetailsMapper = mockk()
	private val systemUnderTest =
		BeerDetailsViewModel(showBeerDetailsUseCase, appSchedulers, beerDetailsMapper)

	@Test
	fun getBeerDetails() {
	}
}