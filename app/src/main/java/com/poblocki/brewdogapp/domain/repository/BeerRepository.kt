package com.poblocki.brewdogapp.domain.repository

import androidx.paging.PagedList
import com.poblocki.brewdogapp.domain.model.Beer
import io.reactivex.Flowable
import io.reactivex.Single

interface BeerRepository {
	fun showBeerDetails(id: Long): Single<Beer>
	fun getBeersByPage(pageSize: Int): Flowable<PagedList<Beer>>
	fun endBeersSubscription()
}