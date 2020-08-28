package com.poblocki.brewdogapp.data.repository

import android.util.Log
import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.data.database.beer.BeerDao
import com.poblocki.brewdogapp.data.database.beer.BeerDbMapper
import com.poblocki.brewdogapp.domain.model.Beer
import io.reactivex.Single
import javax.inject.Inject

class BeerLocalDataSource @Inject constructor(
	private val beerDao: BeerDao,
	private val beerDbMapper: BeerDbMapper,
	private val appSchedulers: AppSchedulers
) {
	fun insertToDatabase(list: List<Beer>): Single<List<Beer>> =
		Single.just(list)
			.map(beerDbMapper::mapToBeerDBList)
			.flatMapCompletable(beerDao::insertAllBeerDbRel)
			.doOnComplete { Log.e("$this", "Inserting to db completed") }
			.subscribeOn(appSchedulers.dbIO)
			.toSingleDefault(list)

	fun getBeerById(id: Long): Single<Beer> =
		beerDao.getById(id)
			.map(beerDbMapper::mapToBeer)
			.subscribeOn(appSchedulers.dbIO)

	fun getBeersWithPaging() =
		beerDao.allWithPaging()
			.map(beerDbMapper::mapToBeer)
}