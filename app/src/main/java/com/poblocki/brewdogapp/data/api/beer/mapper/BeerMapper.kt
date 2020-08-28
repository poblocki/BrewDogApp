package com.poblocki.brewdogapp.data.api.beer.mapper

import com.poblocki.brewdogapp.data.api.beer.model.BeerResponse
import com.poblocki.brewdogapp.data.api.beer.model.HopResponse
import com.poblocki.brewdogapp.data.api.beer.model.MaltResponse
import com.poblocki.brewdogapp.domain.model.Beer
import com.poblocki.brewdogapp.domain.model.Hop
import com.poblocki.brewdogapp.domain.model.Malt
import javax.inject.Inject

class BeerMapper @Inject constructor(
	private val volumeMapper: VolumeMapper,
	private val methodMapper: MethodMapper,
	private val amountMapper: AmountMapper
) {

	fun mapToBeers(beersResponse: List<BeerResponse>): List<Beer> =
		beersResponse
			.map(::mapToBeer)

	private fun mapToBeer(beerResponse: BeerResponse): Beer =
		with(beerResponse) {
			Beer(
				id,
				name ?: "",
				tagline ?: "",
				firstBrewed ?: "",
				description ?: "",
				imageUrl ?: "",
				String.format("%.2f", abv),
				ibu ?: 0.0,
				targetFg ?: 0.0,
				targetOg ?: 0.0,
				ebc ?: 0.0,
				srm ?: 0.0,
				ph ?: 0.0,
				attenuationLevel ?: 0.0,
				volumeMapper.mapVolume(volume),
				volumeMapper.mapVolume(boilVolume),
				methodMapper.mapMethod(method),
				mapMaltList(ingredients?.malt),
				mapHopList(ingredients?.hops),
				foodPairing ?: emptyList(),
				brewersTips ?: "",
				contributedBy ?: ""
			)
		}

	private fun mapMaltList(maltList: List<MaltResponse>?): List<Malt> =
		maltList?.let { response ->
			response.map { mapMalt(it) }
		} ?: emptyList()

	private fun mapMalt(maltResponse: MaltResponse): Malt =
		maltResponse.let {
			Malt(
				it.name ?: "",
				amountMapper.mapAmount(it.amount)
			)
		}

	private fun mapHopList(hopList: List<HopResponse>?): List<Hop> =
		hopList?.let { response ->
			response.map {
				mapHop(it)
			}
		} ?: emptyList()

	private fun mapHop(hopResponse: HopResponse): Hop =
		hopResponse.let {
			Hop(
				it.name ?: "",
				amountMapper.mapAmount(it.amount),
				it.add ?: "",
				it.attribute ?: ""
			)
		}
}