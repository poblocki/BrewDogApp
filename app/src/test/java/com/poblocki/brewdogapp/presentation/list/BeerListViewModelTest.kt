package com.poblocki.brewdogapp.presentation.list

import com.poblocki.brewdogapp.domain.usecase.GetBeersUseCase
import io.mockk.mockk

class BeerListViewModelTest {

	private val getBeersUseCase: GetBeersUseCase = mockk()
	private val systemUnderTest = BeerListViewModel(getBeersUseCase)

}