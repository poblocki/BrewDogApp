package com.poblocki.brewdogapp.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.poblocki.brewdogapp.R
import com.poblocki.brewdogapp.common.BrewDogApplication
import com.poblocki.brewdogapp.presentation.common.di.ActivityModule
import com.poblocki.brewdogapp.presentation.common.di.PresentationComponent

class MainActivity : AppCompatActivity() {

	private val presentationComponent: PresentationComponent by lazy {
		BrewDogApplication.appComponent
			.presentationComponent(ActivityModule(this))
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		presentationComponent.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.main_activity)
	}
}