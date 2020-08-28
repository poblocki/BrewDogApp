package com.poblocki.brewdogapp.presentation.common.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class GlideImageLoader @Inject constructor() :
	ImageLoader {
	override fun loadImage(url: String, imageView: ImageView) {
		Glide.with(imageView.context)
			.load(url)
			.into(imageView)
	}
}