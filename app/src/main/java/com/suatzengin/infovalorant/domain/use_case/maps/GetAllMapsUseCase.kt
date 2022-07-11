package com.suatzengin.infovalorant.domain.use_case.maps

import com.suatzengin.infovalorant.data.remote.maps.toMaps
import com.suatzengin.infovalorant.domain.Maps
import com.suatzengin.infovalorant.domain.repository.ValorantRepository
import com.suatzengin.infovalorant.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetAllMapsUseCase @Inject constructor(
    private val repository: ValorantRepository
) {

    operator fun invoke(): Flow<Resource<List<Maps>>> = flow {
        emit(Resource.Loading())
        try {
            val maps = repository.getAllMaps().data.map {
                it.toMaps()
            }
            emit(Resource.Success(data = maps))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Connection Error!"))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error!"))
        }
    }
}