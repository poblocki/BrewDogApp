package com.poblocki.brewdogapp.data.repository

import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.common.scheduler.TestSchedulers
import com.poblocki.brewdogapp.data.database.beer.BeerDao
import com.poblocki.brewdogapp.data.database.beer.BeerDbMapper
import io.mockk.mockk
import org.junit.Test

class BeerLocalDataSourceTest {

	private val beerDao: BeerDao = mockk()
	private val beerDbMapper: BeerDbMapper = mockk()
	private val appSchedulers: AppSchedulers = TestSchedulers()
	private val systemUnderTest = BeerLocalDataSource(beerDao, beerDbMapper, appSchedulers)

	@Test
	fun insertToDatabase() {
	}

	@Test
	fun getBeerById() {
	}

	@Test
	fun getBeersWithPaging() {
	}
}