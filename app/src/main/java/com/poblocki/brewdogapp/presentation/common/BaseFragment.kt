package com.poblocki.brewdogapp.presentation.common

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.poblocki.brewdogapp.common.BrewDogApplication
import com.poblocki.brewdogapp.presentation.common.di.ActivityModule
import com.poblocki.brewdogapp.presentation.common.di.PresentationComponent
import javax.inject.Inject

open class BaseFragment : Fragment() {
	@Inject
	lateinit var navigator: Navigator

	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	protected val presentationComponent: PresentationComponent by lazy {
		BrewDogApplication.appComponent
			.presentationComponent(ActivityModule(requireActivity()))
	}
}