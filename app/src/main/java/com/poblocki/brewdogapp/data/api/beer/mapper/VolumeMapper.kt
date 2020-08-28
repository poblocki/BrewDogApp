package com.poblocki.brewdogapp.data.api.beer.mapper

import com.poblocki.brewdogapp.data.api.beer.model.VolumeResponse
import com.poblocki.brewdogapp.domain.model.Volume
import javax.inject.Inject

class VolumeMapper @Inject constructor() {
	fun mapVolume(volumeResponse: VolumeResponse?): Volume =
		volumeResponse?.let {
			Volume(
				it.value ?: 0L,
				it.unit ?: ""
			)
		} ?: Volume()
}