package com.poblocki.brewdogapp.domain.model

data class Beer(
	val id: Long,
	val name: String = "",
	val tagline: String = "",
	val firstBrewed: String = "",
	val description: String = "",
	val imageUrl: String = "",
	val abv: String = "",
	val ibu: Double = 0.0,
	val targetFg: Double = 0.0,
	val targetOg: Double = 0.0,
	val ebc: Double = 0.0,
	val srm: Double = 0.0,
	val ph: Double = 0.0,
	val attenuationLevel: Double = 0.0,
	val volume: Volume = Volume(),
	val boilVolume: Volume = Volume(),
	val method: Method = Method(),
	val malt: List<Malt> = emptyList(),
	val hops: List<Hop> = emptyList(),
	val foodPairing: List<String> = emptyList(),
	val brewersTips: String = "",
	val contributedBy: String = ""
)