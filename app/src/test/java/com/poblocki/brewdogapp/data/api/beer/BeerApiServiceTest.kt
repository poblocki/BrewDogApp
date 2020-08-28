package com.poblocki.brewdogapp.data.api.beer

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.Okio
import org.junit.After
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.nio.charset.StandardCharsets

class BeerApiServiceTest {

	private val mockWebServer: MockWebServer = MockWebServer()
	private val rxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()
	private val service: BeerApiService by lazy {
		Retrofit.Builder()
			.baseUrl(mockWebServer.url("/"))
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(rxJava2CallAdapterFactory)
			.build()
			.create(BeerApiService::class.java)
	}

	@After
	fun stopService() {
		mockWebServer.shutdown()
	}


	private fun enqueueErrorResponse() =
		mockWebServer.enqueue(MockResponse().setResponseCode(400))

	private fun enqueueSuccessResponse(fileName: String) {
		val inputStream = javaClass.classLoader!!
			.getResourceAsStream("api-response/$fileName")
		val source = Okio.buffer(Okio.source(inputStream))
		val mockResponse = MockResponse().setResponseCode(200)
		mockWebServer.enqueue(
			mockResponse
				.setBody(source.readString(StandardCharsets.UTF_8))
		)
	}

	@Test
	@Throws(IOException::class, InterruptedException::class)
	fun correctResponseValidationComplete() {
		enqueueSuccessResponse("beer_response.json")
		service.getBeers(1, 20)
			.test()
			.assertComplete()
	}

	@Test
	@Throws(IOException::class, InterruptedException::class)
	fun errorResponse() {
		enqueueErrorResponse()
		service.getBeers(1, 20)
			.test()
			.assertError(HttpException::class.java)
	}
}