package com.poblocki.brewdogapp.data.database.beer

import androidx.room.Embedded
import androidx.room.Relation
import com.poblocki.brewdogapp.data.database.hop.HopDB
import com.poblocki.brewdogapp.data.database.malt.MaltDB

data class BeerDbRel(
	@Embedded
	var beer: BeerDB = BeerDB(),
	@Relation(parentColumn = "id", entityColumn = "beerId", entity = HopDB::class)
	var hops: List<HopDB> = emptyList(),
	@Relation(parentColumn = "id", entityColumn = "beerId", entity = MaltDB::class)
	var malt: List<MaltDB> = emptyList()
)