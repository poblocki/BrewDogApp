package com.poblocki.brewdogapp.presentation.detail

import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.model.Hop
import com.poblocki.brewdogapp.domain.model.Malt
import com.poblocki.brewdogapp.domain.model.Method
import javax.inject.Inject

class BeerDetailsMapper @Inject constructor() {

	fun toDetails(beer: Beer): BeerDetails = BeerDetails(
		beer.name,
		beer.description,
		beer.abv,
		prepareMaltText(beer.malt),
		prepareHopText(beer.hops),
		prepareMethodText(beer.method),
		beer.imageUrl
	)

	private fun prepareMaltText(list: List<Malt>): String {
		return if (list.isNotEmpty()) {
			list.joinToString(
				separator = "\n",
				transform = { "Malt: name ${it.name}, amount ${it.amount}" })
		} else {
			""
		}
	}

	private fun prepareHopText(list: List<Hop>): String {
		return if (list.isNotEmpty()) {
			list.joinToString(separator = "\n",
				transform = { "Hop: name ${it.name}, amount ${it.amount}, \nattribute ${it.attribute} add ${it.add}" })
		} else {
			""
		}
	}

	private fun prepareMethodText(method: Method): String =
		"Fermentation: ${method.fermentation}\nmash temp: ${method.mashTemp}\ntwist: ${method.twist}"
}