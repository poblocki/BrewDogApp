package com.poblocki.brewdogapp.presentation.main

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
	@Test
	fun launchWithEmptyArguments() {
		// Context of the app under test.
		val appContext = InstrumentationRegistry.getInstrumentation().targetContext
		Assert.assertEquals("com.poblocki.brewdogapp", appContext.packageName)
	}
}