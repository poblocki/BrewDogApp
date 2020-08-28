package com.poblocki.brewdogapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.poblocki.brewdogapp.data.database.BrewDogDatabase.Companion.DATABASE_VERSION
import com.poblocki.brewdogapp.data.database.beer.BeerDB
import com.poblocki.brewdogapp.data.database.beer.BeerDao
import com.poblocki.brewdogapp.data.database.hop.HopDB
import com.poblocki.brewdogapp.data.database.hop.HopDao
import com.poblocki.brewdogapp.data.database.malt.MaltDB
import com.poblocki.brewdogapp.data.database.malt.MaltDao

@Database(
	entities = [BeerDB::class, HopDB::class, MaltDB::class],
	version = DATABASE_VERSION
)
@TypeConverters(AmountConverters::class)
abstract class BrewDogDatabase : RoomDatabase() {

	companion object {
		const val DATABASE_VERSION = 1
		private const val DATABASE_NAME = "brewdog.db"

		fun getInstance(context: Context): BrewDogDatabase =
			Room.databaseBuilder(context, BrewDogDatabase::class.java, DATABASE_NAME)
				.addMigrations(*DatabaseMigrations.allMigrations)
				.build()
	}

	abstract fun beerDao(): BeerDao

	abstract fun hopDao(): HopDao

	abstract fun maltDao(): MaltDao
}