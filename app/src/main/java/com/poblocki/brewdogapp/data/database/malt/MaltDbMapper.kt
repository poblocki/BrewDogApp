package com.poblocki.brewdogapp.data.database.malt

import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.model.Malt
import javax.inject.Inject

class MaltDbMapper @Inject constructor() {
	fun toMaltList(maltsDb: List<MaltDB>): List<Malt> =
		maltsDb.map { toMalt(it) }

	private fun toMalt(maltDB: MaltDB): Malt = with(maltDB) {
		Malt(name, amount)
	}

	fun toMaltDBList(beer: Beer, malts: List<Malt>): List<MaltDB> =
		malts.map { toMaltDB(beer, it) }

	private fun toMaltDB(beer: Beer, malt: Malt): MaltDB = with(malt) {
		MaltDB(id, name, beer.id, amount)
	}
}