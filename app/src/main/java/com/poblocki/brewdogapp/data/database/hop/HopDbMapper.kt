package com.poblocki.brewdogapp.data.database.hop

import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.model.Hop
import javax.inject.Inject

class HopDbMapper @Inject constructor() {
	fun toHopList(hopsDB: List<HopDB>): List<Hop> =
		hopsDB.map { toHop(it) }

	private fun toHop(hopDB: HopDB): Hop = with(hopDB) {
		Hop(name, amount, add, attribute)
	}

	fun toHopDbList(beer: Beer, hops: List<Hop>): List<HopDB> =
		hops.map { toHopDB(beer, it) }

	private fun toHopDB(beer: Beer, hop: Hop): HopDB = with(hop) {
		HopDB(id, name, beer.id, amount, add, attribute)
	}
}