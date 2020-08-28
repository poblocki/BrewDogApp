package com.poblocki.brewdogapp.common.di

import android.app.Application
import android.content.Context
import com.poblocki.brewdogapp.common.scheduler.AppSchedulers
import com.poblocki.brewdogapp.common.scheduler.AppSchedulersImpl
import com.poblocki.brewdogapp.data.di.DataModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [DataModule::class])
object BrewDogModule {
	@Singleton
	@JvmStatic
	@Provides
	fun provideApplicationContext(application: Application): Context =
		application.applicationContext

	@JvmStatic
	@Provides
	@Named("dbScheduler")
	internal fun provideDbScheduler(): Scheduler = Schedulers.single()

	@JvmStatic
	@Provides
	@Named("diskIOScheduler")
	internal fun provideDiskIoScheduler(): Scheduler = Schedulers.io()

	@JvmStatic
	@Provides
	@Named("networkScheduler")
	internal fun provideNetworkScheduler(): Scheduler = Schedulers.io()

	@JvmStatic
	@Provides
	@Named("mainThreadScheduler")
	internal fun provideMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()

	@JvmStatic
	@Provides
	@Singleton
	internal fun provideAppSchedulers(
		@Named("dbScheduler") dbIO: Scheduler,
		@Named("diskIOScheduler") diskIO: Scheduler,
		@Named("networkScheduler") networkIO: Scheduler,
		@Named("mainThreadScheduler") mainThread: Scheduler
	): AppSchedulers =
		AppSchedulersImpl(
			dbIO,
			diskIO,
			networkIO,
			mainThread
		)
}