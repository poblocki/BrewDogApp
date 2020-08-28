package com.poblocki.brewdogapp.data.di

import com.poblocki.brewdogapp.BuildConfig
import com.poblocki.brewdogapp.data.api.ApiConfig
import com.poblocki.brewdogapp.data.api.DebugApiConfig
import com.poblocki.brewdogapp.data.api.ReleaseApiConfig
import com.poblocki.brewdogapp.data.api.beer.BeerApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

	companion object Factory {
		const val DEBUG = "debug"
	}

	@Provides
	@Singleton
	fun provideApiConfig(): ApiConfig = when (BuildConfig.BUILD_TYPE) {
		DEBUG -> DebugApiConfig()
		else -> ReleaseApiConfig()
	}

	@Provides
	@Singleton
	internal fun provideHttpLoggingInterceptor(apiConfig: ApiConfig): HttpLoggingInterceptor {
		val httpLoggingInterceptor = HttpLoggingInterceptor()
		if (apiConfig.logHttpBody) {
			httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
		} else {
			httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
		}
		return httpLoggingInterceptor
	}

	@Provides
	@Singleton
	internal fun provideOkHttpClient(
		apiConfig: ApiConfig,
		httpLoggingInterceptor: HttpLoggingInterceptor
	): OkHttpClient =
		OkHttpClient.Builder()
			.addInterceptor(httpLoggingInterceptor)
			.readTimeout(apiConfig.readTimeout, apiConfig.readTimeoutUnit)
			.build()

	@Provides
	@Singleton
	internal fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

	@Provides
	@Singleton
	internal fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory =
		RxJava2CallAdapterFactory.create()

	@Provides
	@Singleton
	internal fun beerApiService(
		apiConfig: ApiConfig,
		okHttpClient: OkHttpClient,
		gsonConverterFactory: GsonConverterFactory,
		rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
	): BeerApiService =
		Retrofit.Builder()
			.baseUrl(apiConfig.baseUrl)
			.client(okHttpClient)
			.addConverterFactory(gsonConverterFactory)
			.addCallAdapterFactory(rxJava2CallAdapterFactory)
			.build()
			.create(BeerApiService::class.java)
}