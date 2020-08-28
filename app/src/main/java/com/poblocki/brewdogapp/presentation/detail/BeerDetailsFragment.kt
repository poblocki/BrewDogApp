package com.poblocki.brewdogapp.presentation.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.poblocki.brewdogapp.R
import com.poblocki.brewdogapp.presentation.common.BaseFragment
import com.poblocki.brewdogapp.presentation.common.image.ImageLoader
import kotlinx.android.synthetic.main.fragment_details.*
import javax.inject.Inject

class BeerDetailsFragment : BaseFragment() {

	private val args: BeerDetailsFragmentArgs by navArgs()

	@Inject
	lateinit var imageLoader: ImageLoader

	private val viewModel: BeerDetailsViewModel by viewModels { viewModelFactory }

	override fun onAttach(context: Context) {
		presentationComponent.inject(this)
		super.onAttach(context)
	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		return inflater.inflate(R.layout.fragment_details, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		back_button.setOnClickListener { navigator.navigateBack() }
		viewModel.beerDetails.observe(viewLifecycleOwner, Observer { beer ->
			title.text = beer.title
			abv.text = getString(R.string.abv_format, beer.abv)
			description.text = beer.description
			malt.text = beer.malt
			hops.text = beer.hops
			method.text = beer.method
			imageLoader.loadImage(beer.imageUrl, image)
		})
		viewModel.getBeerDetails(args.beerId)
	}
}