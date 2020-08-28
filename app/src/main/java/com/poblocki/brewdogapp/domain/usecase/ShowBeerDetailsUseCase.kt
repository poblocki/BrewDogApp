package com.poblocki.brewdogapp.domain.usecase

import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.repository.BeerRepository
import io.reactivex.Single
import javax.inject.Inject

class ShowBeerDetailsUseCase @Inject constructor(private val beerRepository: BeerRepository) {
	fun showBeerDetails(id: Long): Single<Beer> = beerRepository.showBeerDetails(id)
}