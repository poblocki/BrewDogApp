package com.poblocki.brewdogapp.domain.usecase

import com.poblocki.brewdogapp.domain.repository.BeerRepository
import io.mockk.mockk
import org.junit.Test

class ShowBeerDetailsUseCaseTest {

	private val beerRepository: BeerRepository = mockk()
	private val systemUnderTest = ShowBeerDetailsUseCase(beerRepository)

	@Test
	fun showBeerDetails() {
	}
}