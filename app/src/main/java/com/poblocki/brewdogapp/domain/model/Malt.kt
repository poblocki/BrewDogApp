package com.poblocki.brewdogapp.domain.model

data class Malt(
	val name: String = "",
	val amount: Amount = Amount()
) {
	val id: String
		get() = "$name:${amount.value}:${amount.unit}"
}