package com.poblocki.brewdogapp.domain.model

data class Hop(
	val name: String = "",
	val amount: Amount = Amount(),
	val add: String = "",
	val attribute: String = ""
) {
	val id: String
		get() = "$name:${amount.value}:${amount.unit}:$add:$attribute"
}