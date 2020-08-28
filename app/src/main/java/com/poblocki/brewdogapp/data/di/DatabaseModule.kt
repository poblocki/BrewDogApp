package com.poblocki.brewdogapp.data.di

import android.content.Context
import com.poblocki.brewdogapp.data.database.BrewDogDatabase
import com.poblocki.brewdogapp.data.database.beer.BeerDao
import com.poblocki.brewdogapp.data.database.hop.HopDao
import com.poblocki.brewdogapp.data.database.malt.MaltDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

	@Provides
	@Singleton
	internal fun brewDogDatabase(context: Context): BrewDogDatabase =
		BrewDogDatabase.getInstance(
			context
		)

	@Provides
	@Singleton
	internal fun beerDao(db: BrewDogDatabase): BeerDao = db.beerDao()


	@Provides
	@Singleton
	internal fun hopDao(db: BrewDogDatabase): HopDao = db.hopDao()


	@Provides
	@Singleton
	internal fun maltDao(db: BrewDogDatabase): MaltDao = db.maltDao()
}