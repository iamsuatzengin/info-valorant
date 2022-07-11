package com.suatzengin.infovalorant.di

import com.suatzengin.infovalorant.data.remote.ValorantApiService
import com.suatzengin.infovalorant.data.repository.ValorantRepositoryImpl
import com.suatzengin.infovalorant.domain.repository.ValorantRepository
import com.suatzengin.infovalorant.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ValorantApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ValorantApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(apiService: ValorantApiService): ValorantRepository {
        return ValorantRepositoryImpl(apiService)
    }

}