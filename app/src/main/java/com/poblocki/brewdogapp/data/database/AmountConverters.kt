package com.poblocki.brewdogapp.data.database

import androidx.room.TypeConverter
import com.poblocki.brewdogapp.domain.model.Amount

object AmountConverters {

	@TypeConverter
	@JvmStatic
	fun fromString(value: String?) = value?.let {
		val splitted = it.split(",")
		Amount(splitted[0].toDouble(), splitted[1])
	}


	@TypeConverter
	@JvmStatic
	fun amountToString(amount: Amount?): String = amount?.let {
		it.value.toString() + "," + it.unit
	} ?: ""
}
