package com.suatzengin.infovalorant.data.repository

import com.suatzengin.infovalorant.data.remote.ValorantApiService
import com.suatzengin.infovalorant.data.remote.agents.Agents
import com.suatzengin.infovalorant.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class ValorantRepository @Inject constructor(
    private val apiService: ValorantApiService
) {

    fun getAllAgents(): Flow<Resource<List<Agents>>> = flow {
        try {
            emit(Resource.Loading())
            val agents = apiService.getAllAgents().data
            emit(Resource.Success(data = agents))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Network Error!"))
        } catch (e: java.lang.Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        }
    }
}