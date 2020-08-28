package com.poblocki.brewdogapp.domain.model

data class Volume(
	val value: Long = 0L,
	val unit: String = ""
) {
	init {
		require(value >= 0.0) {
			"Volume must have a non-negative value."
		}
	}
}