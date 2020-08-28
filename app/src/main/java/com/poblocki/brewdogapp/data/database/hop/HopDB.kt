package com.poblocki.brewdogapp.data.database.hop

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.poblocki.brewdogapp.data.database.beer.BeerDB
import com.poblocki.brewdogapp.domain.model.Amount

@Entity(
	tableName = "Hop",
	indices = [(Index("id"))],
	foreignKeys = [(ForeignKey(
		entity = BeerDB::class,
		parentColumns = arrayOf("id"),
		childColumns = arrayOf("beerId"),
		onDelete = ForeignKey.CASCADE
	))]
)
data class HopDB(
	@field:PrimaryKey val id: String,
	val name: String,
	val beerId: Long,
	val amount: Amount,
	val add: String,
	val attribute: String
)