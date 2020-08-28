package com.poblocki.brewdogapp.presentation.common.di

import com.poblocki.brewdogapp.presentation.detail.BeerDetailsFragment
import com.poblocki.brewdogapp.presentation.list.BeerListFragment
import com.poblocki.brewdogapp.presentation.main.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class, ViewModelModule::class])
interface PresentationComponent {
	fun inject(activity: MainActivity)

	fun inject(fragment: BeerListFragment)

	fun inject(fragment: BeerDetailsFragment)
}