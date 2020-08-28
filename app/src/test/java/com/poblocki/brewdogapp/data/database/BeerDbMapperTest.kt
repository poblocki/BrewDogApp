package com.poblocki.brewdogapp.data.database

import com.poblocki.brewdogapp.data.database.beer.BeerDbMapper
import com.poblocki.brewdogapp.data.database.hop.HopDbMapper
import com.poblocki.brewdogapp.data.database.malt.MaltDbMapper
import com.poblocki.brewdogapp.data.database.method.MethodDbMapper
import io.mockk.mockk
import org.junit.Test

class BeerDbMapperTest {

	private val methodDbMapper: MethodDbMapper = mockk()
	private val hopDbMapper: HopDbMapper = mockk()
	private val maltDbMapper: MaltDbMapper = mockk()
	private val systemUnderTest =
		BeerDbMapper(methodDbMapper, hopDbMapper, maltDbMapper)

	@Test
	fun test() {

	}
}