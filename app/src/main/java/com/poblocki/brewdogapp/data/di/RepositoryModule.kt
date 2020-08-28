package com.poblocki.brewdogapp.data.di

import com.poblocki.brewdogapp.data.repository.BeerRepositoryImpl
import com.poblocki.brewdogapp.domain.repository.BeerRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {
	@Binds
	@Singleton
	internal abstract fun bindBeerRepository(repository: BeerRepositoryImpl): BeerRepository
}