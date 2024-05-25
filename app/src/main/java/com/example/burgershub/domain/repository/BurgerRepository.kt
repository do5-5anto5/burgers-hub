package com.example.burgershub.domain.repository

import com.example.burgershub.data.model.BurgerResponse

interface BurgerRepository {

    suspend fun getBurgers(): List<BurgerResponse>

    suspend fun getBurgerById(burgerId: Int): BurgerResponse

    suspend fun getBurgerByName(burgerName: String): List<BurgerResponse>

}