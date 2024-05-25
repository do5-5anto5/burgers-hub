package com.example.burgershub.data.repository

import com.example.burgershub.data.api.ApiService
import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.domain.repository.BurgerRepository
import javax.inject.Inject

class BurgerRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BurgerRepository {

    override suspend fun getBurgers(): List<BurgerResponse> {
        return apiService.getBurgers()
    }

    override suspend fun getBurgerById(burgerId: Int): BurgerResponse {
        return apiService.getBurgerById(burgerId)
    }

    override suspend fun getBurgerByName(burgerName: String): List<BurgerResponse> {
        return apiService.getBurgerByName(burgerName)
    }
}