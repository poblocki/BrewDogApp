package com.poblocki.brewdogapp.data.database.method

import com.poblocki.brewdogapp.domain.model.Method
import javax.inject.Inject

class MethodDbMapper @Inject constructor() {
	fun toMethod(methodDB: MethodDB): Method = with(methodDB) {
		Method(mashTemp, fermentation, twist)
	}

	fun toMethodDB(method: Method): MethodDB = with(method) {
		MethodDB(
			mashTemp,
			fermentation,
			twist
		)
	}
}