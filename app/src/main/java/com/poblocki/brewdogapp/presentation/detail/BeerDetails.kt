package com.poblocki.brewdogapp.presentation.detail

data class BeerDetails(
	val title: String,
	val description: String,
	val abv: String,
	val malt: String,
	val hops: String,
	val method: String,
	val imageUrl: String
)