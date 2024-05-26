package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerResponse
import io.github.brunogabriel.mockpinterceptor.MOCK
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @MOCK(asset = "burgers.json", runDelay = true)
    @GET("burgers")
    suspend fun getBurgers(): List<BurgerResponse>

    @MOCK(asset = "burger.json", runDelay = true)
    @GET("burgers/{id}")
    suspend fun getBurgerById(
        @Path("id")burgerId: Int)
    : BurgerResponse

    @MOCK(asset = "burger_name.json", runDelay = true)
    @GET("find-burger/")
    suspend fun getBurgerByName(
        @Query("search") burgerName: String)
    : List<BurgerResponse>
}