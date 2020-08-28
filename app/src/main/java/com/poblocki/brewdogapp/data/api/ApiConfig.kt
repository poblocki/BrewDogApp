package com.poblocki.brewdogapp.data.api

import java.util.concurrent.TimeUnit

abstract class ApiConfig {
	open val baseUrl: String = "https://api.punkapi.com/v2/"
	abstract val logHttpBody: Boolean
	val readTimeout: Long = 60_000
	val readTimeoutUnit: TimeUnit = TimeUnit.MILLISECONDS
}

class DebugApiConfig : ApiConfig() {
	//	override val baseUrl: String = "https://test.api.punkapi.com/v2/"
	override val logHttpBody: Boolean = true
}

class ReleaseApiConfig : ApiConfig() {
	override val logHttpBody: Boolean = false
}