package com.suatzengin.infovalorant.data.remote

import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.util.Constants
import retrofit2.http.GET

interface ValorantApiService {

    @GET(Constants.AGENTS)
    suspend fun getAllAgents(): Response<Agents>

}