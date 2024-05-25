package com.example.burgershub.di

import com.example.burgershub.data.api.ApiService
import com.example.burgershub.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun providesApiService(
        serviceProvider: ServiceProvider
    ): ApiService{
    return serviceProvider.createService(ApiService::class.java)
    }

}