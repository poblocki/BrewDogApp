package com.poblocki.brewdogapp.data.api.beer.mapper

import com.poblocki.brewdogapp.data.api.beer.model.AmountResponse
import com.poblocki.brewdogapp.domain.model.Amount
import javax.inject.Inject

class AmountMapper @Inject constructor() {
	fun mapAmount(amountResponse: AmountResponse?): Amount =
		amountResponse?.let {
			Amount(
				it.value ?: 0.0,
				it.unit ?: ""
			)
		} ?: Amount()
}