package com.poblocki.brewdogapp.domain.model

import org.amshove.kluent.shouldEqual
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class AmountTest {

	@Rule
	@JvmField
	var exceptionRule: ExpectedException = ExpectedException.none()

	@Test
	fun testEmptyAmount() {
		val amount = Amount()
		amount.value shouldEqual 0.0
		amount.unit shouldEqual ""
	}

	@Test
	fun testInvalidAmount() {
		exceptionRule.expect(IllegalArgumentException::class.java)
		Amount(-123.0, "Invalid unit")
	}
}