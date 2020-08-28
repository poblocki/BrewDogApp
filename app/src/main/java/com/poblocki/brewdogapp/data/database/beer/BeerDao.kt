package com.poblocki.brewdogapp.data.database.beer

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poblocki.brewdogapp.data.database.BrewDogDatabase
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class BeerDao(private val db: BrewDogDatabase) {
	@Insert(onConflict = OnConflictStrategy.IGNORE)
	abstract fun insert(beer: BeerDB)

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	abstract fun insertAll(beers: List<BeerDB>): Completable

	@Query("SELECT * FROM Beer WHERE id = :id")
	abstract fun getById(id: Long): Single<BeerDbRel>

	@Query("SELECT * FROM Beer")
	abstract fun getBeers(): Flowable<List<BeerDbRel>>

	@Query("SELECT * FROM Beer")
	abstract fun allWithPaging(): DataSource.Factory<Int, BeerDbRel>

	open fun insertAllBeerDbRel(beerDbRels: List<BeerDbRel>): Completable =
		Completable.fromAction {
			beerDbRels.forEach { beerDbRel ->
				insert(beerDbRel.beer)
				db.hopDao().insertAll(beerDbRel.hops)
				db.maltDao().insertAll(beerDbRel.malt)
			}
		}
}