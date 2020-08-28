package com.poblocki.brewdogapp.data.api.beer.mapper

import com.poblocki.brewdogapp.data.api.beer.model.FermentationResponse
import com.poblocki.brewdogapp.data.api.beer.model.MashTempResponse
import com.poblocki.brewdogapp.data.api.beer.model.MethodResponse
import com.poblocki.brewdogapp.data.api.beer.model.TempResponse
import com.poblocki.brewdogapp.domain.model.Method
import javax.inject.Inject

class MethodMapper @Inject constructor() {
	fun mapMethod(methodResponse: MethodResponse?): Method =
		methodResponse?.let {
			Method(
				mapMashTemp(it.mashTemp),
				mapFermentation(it.fermentation),
				it.twist ?: ""
			)
		}
			?: Method()

	private fun mapMashTemp(mashTemp: List<MashTempResponse>?): String = mashTemp?.let { list ->
		list.joinToString {
			"Temp. " + mapTempResponse(it.temp) + " duration: " + it.duration
		}
	} ?: ""

	private fun mapFermentation(fermentation: FermentationResponse?): String =
		fermentation?.let {
			mapTempResponse(it.temp)
		} ?: ""

	private fun mapTempResponse(tempResponse: TempResponse?): String = tempResponse?.let {
		"${it.value} ${it.unit}"
	} ?: ""
}