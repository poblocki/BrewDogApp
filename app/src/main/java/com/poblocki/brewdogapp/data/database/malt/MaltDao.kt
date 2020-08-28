package com.poblocki.brewdogapp.data.database.malt

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface MaltDao {
	@Insert(onConflict = OnConflictStrategy.IGNORE)
	fun insertAll(malts: List<MaltDB>)
}