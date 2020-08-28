package com.poblocki.brewdogapp.presentation.common.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poblocki.brewdogapp.presentation.common.image.GlideImageLoader
import com.poblocki.brewdogapp.presentation.common.image.ImageLoader
import com.poblocki.brewdogapp.presentation.detail.BeerDetailsViewModel
import com.poblocki.brewdogapp.presentation.list.BeerListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
	@Binds
	abstract fun bindImageLoader(glideImageLoader: GlideImageLoader): ImageLoader

	@Binds
	abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

	@Binds
	@IntoMap
	@ViewModelKey(BeerDetailsViewModel::class)
	abstract fun bindBeerDetailsViewModel(viewModel: BeerDetailsViewModel): ViewModel

	@Binds
	@IntoMap
	@ViewModelKey(BeerListViewModel::class)
	abstract fun bindBeerListViewModel(viewModel: BeerListViewModel): ViewModel
}