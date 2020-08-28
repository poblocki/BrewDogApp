package com.poblocki.brewdogapp.common

import android.app.Application
import com.poblocki.brewdogapp.common.di.BrewDogComponent
import com.poblocki.brewdogapp.common.di.DaggerBrewDogComponent

class BrewDogApplication : Application() {
	companion object {
		lateinit var appComponent: BrewDogComponent
	}

	override fun onCreate() {
		super.onCreate()
		appComponent = DaggerBrewDogComponent.builder()
			.application(this)
			.build()
	}
}