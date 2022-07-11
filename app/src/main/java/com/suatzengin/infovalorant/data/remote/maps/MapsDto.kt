package com.suatzengin.infovalorant.data.remote.maps

import com.suatzengin.infovalorant.domain.Maps

data class MapsDto(
    val uuid: String,
    val displayName: String,
    val coordinates: String,
    val displayIcon: String,
    val listViewIcon: String,
    val splash: String,
    val assetPath: String,
    val mapUrl: String,
    val xMultiplier: Double,
    val yMultiplier: Double,
    val xScalarToAdd: Double,
    val yScalarToAdd: Double,
    val callouts: List<Callouts>
)

fun MapsDto.toMaps(): Maps {
    return Maps(
        uuid = uuid,
        displayName = displayName,
        coordinates = coordinates,
        displayIcon = displayIcon,
        listViewIcon = listViewIcon,
        splash = splash
    )
}