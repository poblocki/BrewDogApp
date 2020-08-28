package com.poblocki.brewdogapp.data.database.beer

import com.poblocki.brewdogapp.data.database.hop.HopDbMapper
import com.poblocki.brewdogapp.data.database.malt.MaltDbMapper
import com.poblocki.brewdogapp.data.database.method.MethodDbMapper
import com.poblocki.brewdogapp.domain.model.Beer
import javax.inject.Inject

class BeerDbMapper @Inject constructor(
	private val methodDbMapper: MethodDbMapper,
	private val hopDbMapper: HopDbMapper,
	private val maltDbMapper: MaltDbMapper
) {
	fun mapToBeer(beerDbRel: BeerDbRel): Beer = with(beerDbRel) {
		val beerDb = beerDbRel.beer
		Beer(
			beerDb.id,
			name = beerDb.name,
			imageUrl = beerDb.imageUrl,
			abv = beerDb.abv,
			description = beerDb.description,
			method = methodDbMapper.toMethod(beerDb.method),
			hops = hopDbMapper.toHopList(beerDbRel.hops),
			malt = maltDbMapper.toMaltList(beerDbRel.malt)
		)
	}

	fun mapToBeerDBList(list: List<Beer>): List<BeerDbRel> =
		list.map(::mapToBeerDBRel)

	private fun mapToBeerDBRel(beer: Beer): BeerDbRel = with(beer) {
		val beerDB = BeerDB(
			id,
			name,
			imageUrl,
			abv,
			description,
			methodDbMapper.toMethodDB(method)
		)
		val hopsDb = hopDbMapper.toHopDbList(beer, hops)
		val maltsDb = maltDbMapper.toMaltDBList(beer, malt)
		BeerDbRel(beerDB, hopsDb, maltsDb)
	}
}