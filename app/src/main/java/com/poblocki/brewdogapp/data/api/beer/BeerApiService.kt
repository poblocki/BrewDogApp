package com.poblocki.brewdogapp.data.api.beer

import com.poblocki.brewdogapp.data.api.beer.model.BeerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApiService {
	@GET("beers")
	fun getBeers(
		@Query("page") page: Int,
		@Query("per_page") perPage: Int
	): Single<List<BeerResponse>>
}