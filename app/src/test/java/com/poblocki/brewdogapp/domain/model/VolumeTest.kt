package com.poblocki.brewdogapp.domain.model

import org.amshove.kluent.shouldEqual
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class VolumeTest {


	@Rule
	@JvmField
	var exceptionRule: ExpectedException = ExpectedException.none()

	@Test
	fun testEmptyVolume() {
		val volume = Volume()
		volume.value shouldEqual 0L
		volume.unit shouldEqual ""
	}

	@Test
	fun testInvalidVolume() {
		exceptionRule.expect(IllegalArgumentException::class.java)
		Volume(-123, "Invalid unit")
	}
}