package com.poblocki.brewdogapp.data.api.beer.model

import com.google.gson.annotations.SerializedName

data class BeerResponse(
	@SerializedName("id") val id: Long,
	@SerializedName("name") val name: String?,
	@SerializedName("tagline") val tagline: String?,
	@SerializedName("first_brewed") val firstBrewed: String?,
	@SerializedName("description") val description: String?,
	@SerializedName("image_url") val imageUrl: String?,
	@SerializedName("abv") val abv: Double?,
	@SerializedName("ibu") val ibu: Double?,
	@SerializedName("target_fg") val targetFg: Double?,
	@SerializedName("target_og") val targetOg: Double?,
	@SerializedName("ebc") val ebc: Double?,
	@SerializedName("srm") val srm: Double?,
	@SerializedName("ph") val ph: Double?,
	@SerializedName("attenuation_level") val attenuationLevel: Double?,
	@SerializedName("volume") val volume: VolumeResponse?,
	@SerializedName("boil_volume") val boilVolume: VolumeResponse?,
	@SerializedName("method") val method: MethodResponse?,
	@SerializedName("ingredients") val ingredients: IngredientsResponse?,
	@SerializedName("food_pairing") val foodPairing: List<String>?,
	@SerializedName("brewers_tips") val brewersTips: String?,
	@SerializedName("contributed_by") val contributedBy: String?
)

data class VolumeResponse(
	@SerializedName("value") val value: Long?,
	@SerializedName("unit") val unit: String?
)

data class MethodResponse(
	@SerializedName("mash_temp") val mashTemp: List<MashTempResponse>?,
	@SerializedName("fermentation") val fermentation: FermentationResponse?,
	@SerializedName("twist") val twist: String?
)

data class MashTempResponse(
	@SerializedName("temp") val temp: TempResponse?,
	@SerializedName("duration") val duration: Long?
)

data class TempResponse(
	@SerializedName("value") val value: Double?,
	@SerializedName("unit") val unit: String?
)

data class FermentationResponse(@SerializedName("temp") val temp: TempResponse?)

data class IngredientsResponse(
	@SerializedName("malt") val malt: List<MaltResponse>?,
	@SerializedName("hops") val hops: List<HopResponse>?,
	@SerializedName("yeast") val yeast: String?
)

data class MaltResponse(
	@SerializedName("name") val name: String?,
	@SerializedName("amount") val amount: AmountResponse?
)

data class HopResponse(
	@SerializedName("name") val name: String?,
	@SerializedName("amount") val amount: AmountResponse?,
	@SerializedName("add") val add: String?,
	@SerializedName("attribute") val attribute: String?
)

data class AmountResponse(
	@SerializedName("value") val value: Double?,
	@SerializedName("unit") val unit: String?
)



