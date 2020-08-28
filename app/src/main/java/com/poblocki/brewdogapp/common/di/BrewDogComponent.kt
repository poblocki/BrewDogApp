package com.poblocki.brewdogapp.common.di

import android.app.Application
import com.poblocki.brewdogapp.presentation.common.di.ActivityModule
import com.poblocki.brewdogapp.presentation.common.di.PresentationComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [BrewDogModule::class])
interface BrewDogComponent {
	@Component.Builder
	interface Builder {
		@BindsInstance
		fun application(application: Application): Builder
		fun build(): BrewDogComponent
	}

	fun presentationComponent(activityModule: ActivityModule): PresentationComponent
}