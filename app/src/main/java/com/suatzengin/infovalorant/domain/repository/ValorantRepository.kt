package com.suatzengin.infovalorant.domain.repository

import com.suatzengin.infovalorant.data.remote.Response
import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.data.remote.maps.MapsDto



interface ValorantRepository {
    // Agents
    suspend fun getAllAgents(): Response<Agents>

    // Maps
    suspend fun getAllMaps(): Response<MapsDto>

}