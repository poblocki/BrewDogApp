package com.poblocki.brewdogapp.presentation.common

import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.poblocki.brewdogapp.R
import com.poblocki.brewdogapp.presentation.common.di.ActivityScope
import com.poblocki.brewdogapp.presentation.detail.BeerDetailsFragmentDirections
import javax.inject.Inject

@ActivityScope
class Navigator @Inject constructor(private val fragmentActivity: FragmentActivity) {

	private val navController
		get() = fragmentActivity.findNavController(R.id.my_nav_host_fragment)

	fun navigateToBeerDetails(id: Long) {
		val directions = BeerDetailsFragmentDirections.actionBeerDetails(id)
		navController.navigate(directions)
	}

	fun navigateBack() = navController.popBackStack()
}