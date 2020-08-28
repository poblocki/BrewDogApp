package com.poblocki.brewdogapp.data.di

import dagger.Module

@Module(includes = [ApiModule::class, DatabaseModule::class, RepositoryModule::class])
object DataModule