package com.poblocki.brewdogapp.presentation.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.poblocki.brewdogapp.R
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.presentation.common.image.ImageLoader
import kotlinx.android.synthetic.main.item_beer.view.*

class BeerViewHolder(
	private val view: View,
	private val imageLoader: ImageLoader,
	private val clickListener: OnBeerClickListener
) : RecyclerView.ViewHolder(view) {
	fun bindTo(beer: Beer?) {
		beer?.run {
			itemView.name.text = name
			itemView.abv.text = view.context.getString(R.string.abv_format, beer.abv)
			imageLoader.loadImage(imageUrl, itemView.thumbnail)
			itemView.setOnClickListener {
				clickListener.invoke(this)
			}
		}
	}

	companion object {
		fun create(
			parent: ViewGroup,
			imageLoader: ImageLoader,
			clickListener: OnBeerClickListener
		): BeerViewHolder {
			val layoutInflater = LayoutInflater.from(parent.context)
			val view = layoutInflater.inflate(R.layout.item_beer, parent, false)
			return BeerViewHolder(
				view,
				imageLoader,
				clickListener
			)
		}
	}
}