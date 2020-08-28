package com.poblocki.brewdogapp.data.repository

import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.data.api.beer.BeerApiService
import com.poblocki.brewdogapp.data.api.beer.mapper.BeerMapper
import com.poblocki.brewdogapp.domain.model.Beer
import io.reactivex.Single
import javax.inject.Inject

class BeerRemoteDataSource @Inject constructor(
	private val beerApiService: BeerApiService,
	private val beerMapper: BeerMapper,
	private val appSchedulers: AppSchedulers
) {
	fun getFromApi(page: Int, pageSize: Int): Single<List<Beer>> =
		beerApiService.getBeers(page, pageSize)
			.map(beerMapper::mapToBeers)
			.subscribeOn(appSchedulers.networkIO)
}