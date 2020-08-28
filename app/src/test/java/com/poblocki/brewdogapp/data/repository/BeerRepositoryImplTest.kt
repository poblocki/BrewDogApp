package com.poblocki.brewdogapp.data.repository

import com.poblocki.brewdogapp.domain.model.Beer
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Single
import org.junit.Test

class BeerRepositoryImplTest {

	private val beerLocalDataSource: BeerLocalDataSource = mockk()
	private val beerBoundaryCallback: BeerBoundaryCallback = mockk()
	private val systemUnderTest = BeerRepositoryImpl(beerLocalDataSource, beerBoundaryCallback)

	@Test
	fun showBeerDetails() {
		val beerId = 1L
		val beer = Beer(beerId)
		every { beerLocalDataSource.getBeerById(beerId) } returns Single.just(beer)

		systemUnderTest.showBeerDetails(beerId)
			.test()
			.assertValue(beer)
		
		verify { beerLocalDataSource.getBeerById(beerId) }
	}

	@Test
	fun endBeersSubscription() {

	}

	@Test
	fun getBeersByPage() {

	}
}