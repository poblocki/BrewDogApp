package com.poblocki.brewdogapp.data.repository

import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.common.scheduler.TestSchedulers
import io.mockk.mockk
import org.junit.Test

class BeerBoundaryCallbackTest {

	private val beerLocalDataSource: BeerLocalDataSource = mockk()
	private val beerRemoteDataSource: BeerRemoteDataSource = mockk()
	private val appSchedulers: AppSchedulers = TestSchedulers()
	private val systemUnderTest =
		BeerBoundaryCallback(beerLocalDataSource, beerRemoteDataSource, appSchedulers)

	@Test
	fun onZeroItemsLoaded() {
	}
}