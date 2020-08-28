package com.poblocki.brewdogapp.data.database.hop

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface HopDao {
	@Insert(onConflict = OnConflictStrategy.IGNORE)
	fun insertAll(hops: List<HopDB>)
}