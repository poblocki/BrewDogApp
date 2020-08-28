package com.poblocki.brewdogapp.presentation.list.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.presentation.common.image.ImageLoader

class BeerAdapter(
	private val imageLoader: ImageLoader,
	private val clickListener: OnBeerClickListener
) :
	PagedListAdapter<Beer, RecyclerView.ViewHolder>(BeerDiffCallback) {

	companion object {
		val BeerDiffCallback = object : DiffUtil.ItemCallback<Beer>() {
			override fun areItemsTheSame(oldItem: Beer, newItem: Beer): Boolean {
				return oldItem.id == newItem.id
			}

			override fun areContentsTheSame(oldItem: Beer, newItem: Beer): Boolean {
				return oldItem == newItem
			}
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
		BeerViewHolder.create(parent, imageLoader, clickListener)

	override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
		(holder as BeerViewHolder).bindTo(getItem(position))
	}
}