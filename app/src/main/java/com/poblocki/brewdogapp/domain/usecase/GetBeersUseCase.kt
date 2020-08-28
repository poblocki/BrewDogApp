package com.poblocki.brewdogapp.domain.usecase

import com.poblocki.brewdogapp.domain.repository.BeerRepository
import javax.inject.Inject

class GetBeersUseCase @Inject constructor(private val beerRepository: BeerRepository) {
	fun getBeersByPage(pageSize: Int) = beerRepository.getBeersByPage(pageSize)
	fun endBeersSubscription() = beerRepository.endBeersSubscription()
}