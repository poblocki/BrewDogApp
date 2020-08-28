package com.poblocki.brewdogapp.data.api.beer.mapper

import io.mockk.mockk
import org.junit.Test

class BeerMapperTest {
	private val volumeMapper: VolumeMapper = mockk()
	private val methodMapper: MethodMapper = mockk()
	private val amountMapper: AmountMapper = mockk()
	private val systemUnderTest = BeerMapper(volumeMapper, methodMapper, amountMapper)

	@Test
	fun test() {

	}
}