package com.poblocki.brewdogapp.data.database.beer

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.poblocki.brewdogapp.data.database.method.MethodDB

@Entity(
	tableName = "Beer",
	indices = [(Index("id"))]
)
data class BeerDB(
	@field:PrimaryKey val id: Long = 0L,
	val name: String = "",
	val imageUrl: String = "",
	val abv: String = "",
	val description: String = "",
	@Embedded val method: MethodDB = MethodDB()
)