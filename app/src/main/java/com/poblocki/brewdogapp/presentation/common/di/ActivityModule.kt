package com.poblocki.brewdogapp.presentation.common.di

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: FragmentActivity) {
	@Provides
	fun provideFragmentActivity(): FragmentActivity = activity
}