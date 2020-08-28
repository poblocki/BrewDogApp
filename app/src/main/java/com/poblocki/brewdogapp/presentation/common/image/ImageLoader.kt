package com.poblocki.brewdogapp.presentation.common.image

import android.widget.ImageView

interface ImageLoader {
	fun loadImage(url: String, imageView: ImageView)
}