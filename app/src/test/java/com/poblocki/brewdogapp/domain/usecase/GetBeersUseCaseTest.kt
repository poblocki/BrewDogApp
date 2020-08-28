package com.poblocki.brewdogapp.domain.usecase

import com.poblocki.brewdogapp.domain.repository.BeerRepository
import io.mockk.mockk
import org.junit.Test

class GetBeersUseCaseTest {

	private val beerRepository: BeerRepository = mockk()
	private val systemUnderTest = GetBeersUseCase(beerRepository)

	@Test
	fun getBeersByPage() {
	}

	@Test
	fun endBeersSubscription() {
	}
}