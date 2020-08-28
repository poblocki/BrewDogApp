package com.poblocki.brewdogapp.data.database

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.poblocki.brewdogapp.data.database.beer.BeerDB
import com.poblocki.brewdogapp.data.database.beer.BeerDbRel
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.IOException

class BeerDaoTest {
	private lateinit var database: BrewDogDatabase

	@Before
	fun initDatabase() {
		database = Room.inMemoryDatabaseBuilder(
			InstrumentationRegistry.getInstrumentation().targetContext,
			BrewDogDatabase::class.java
		).build()
	}

	@After
	@Throws(IOException::class)
	fun closeDatabase() {
		database.close()
	}

	@Test
	@Throws(InterruptedException::class)
	fun insertAndGetProperBeerFromDb() {
		val beerDB = BeerDB(
			1L,
			"Rabiator",
			"https://images.punkapi.com/v2/keg.png",
			10.27f,
			"Imperial Wheat beer"
		)
		val beerDbRel = BeerDbRel(beerDB)

		database.beerDao()
			.insertAllBeerDbRel(listOf(beerDbRel))
			.test()
			.assertComplete()


		database.beerDao()
			.getById(1L)
			.test()
			.assertValue(beerDbRel)
	}
}