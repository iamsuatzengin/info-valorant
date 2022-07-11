package com.suatzengin.infovalorant.presentation.maps

import com.suatzengin.infovalorant.domain.Maps

data class MapsState(
    val maps: List<Maps> = emptyList(),
    val error: String = "",
    val isLoading: Boolean = false
)
