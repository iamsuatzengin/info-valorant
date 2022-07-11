package com.suatzengin.infovalorant.data.repository

import com.suatzengin.infovalorant.data.remote.Response
import com.suatzengin.infovalorant.data.remote.ValorantApiService
import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.data.remote.maps.MapsDto
import com.suatzengin.infovalorant.domain.Maps
import com.suatzengin.infovalorant.domain.repository.ValorantRepository
import com.suatzengin.infovalorant.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class ValorantRepositoryImpl @Inject constructor(
    private val apiService: ValorantApiService
) : ValorantRepository {

    override suspend fun getAllAgents(): Response<Agents> = apiService.getAllAgents()

    override suspend fun getAllMaps(): Response<MapsDto> = apiService.getAllMaps()

}
