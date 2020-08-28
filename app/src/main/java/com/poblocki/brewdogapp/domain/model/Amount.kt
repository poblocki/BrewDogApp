package com.poblocki.brewdogapp.domain.model

data class Amount(
	val value: Double = 0.0,
	val unit: String = ""
) {
	init {
		require(value >= 0.0) {
			"Amount must have a non-negative value."
		}
	}

	override fun toString(): String = "$value $unit"
}