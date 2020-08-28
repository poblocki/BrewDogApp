package com.poblocki.brewdogapp.data.repository

import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.common.scheduler.TestSchedulers
import com.poblocki.brewdogapp.data.api.beer.BeerApiService
import com.poblocki.brewdogapp.data.api.beer.mapper.BeerMapper
import io.mockk.mockk
import org.junit.Test

class BeerRemoteDataSourceTest {

	private val beerApiService: BeerApiService = mockk()
	private val beerMapper: BeerMapper = mockk()
	private val appSchedulers: AppSchedulers = TestSchedulers()
	private val systemUnderTest = BeerRemoteDataSource(beerApiService, beerMapper, appSchedulers)

	@Test
	fun getFromApi() {
	}
}