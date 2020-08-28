package com.poblocki.brewdogapp.presentation.common.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import javax.inject.Inject
import javax.inject.Provider

@ActivityScope
class ViewModelFactory @Inject constructor(
	private val viewModels: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
	@Suppress("UNCHECKED_CAST")
	override fun <T : ViewModel?> create(modelClass: Class<T>): T =
		viewModels[modelClass]?.get() as T
}

inline fun <reified VM : ViewModel> ViewModelProvider.Factory.obtainViewModel(activity: FragmentActivity): VM {
	return ViewModelProviders.of(activity, this)[VM::class.java]
}