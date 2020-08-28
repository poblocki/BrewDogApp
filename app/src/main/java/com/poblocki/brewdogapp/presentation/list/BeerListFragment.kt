package com.poblocki.brewdogapp.presentation.list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.poblocki.brewdogapp.R
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.presentation.common.BaseFragment
import com.poblocki.brewdogapp.presentation.common.image.ImageLoader
import com.poblocki.brewdogapp.presentation.list.adapter.BeerAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class BeerListFragment : BaseFragment() {

	@Inject
	lateinit var imageLoader: ImageLoader

	private val viewModel: BeerListViewModel by viewModels { viewModelFactory }

	override fun onAttach(context: Context) {
		presentationComponent.inject(this)
		super.onAttach(context)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return inflater.inflate(R.layout.fragment_list, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		val adapter = BeerAdapter(imageLoader, ::onBeerClicked)
		list.layoutManager = LinearLayoutManager(requireContext())
		list.adapter = adapter
		viewModel.beerList.observe(viewLifecycleOwner, Observer { beers ->
			adapter.submitList(beers)
		})
	}

	private fun onBeerClicked(beer: Beer) = navigator.navigateToBeerDetails(beer.id)
}