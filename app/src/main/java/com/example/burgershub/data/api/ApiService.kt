package com.example.burgershub.data.api

import com.example.burgershub.data.model.BurgerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("burgers")
    suspend fun getBurgers(): List<BurgerResponse>

    @GET("burgers/{id}")

    suspend fun getBurgerById(
        @Path("id")burgerId: Int)
    : BurgerResponse

    @GET("find-burger/{name}")
    suspend fun getBurgerByName(
        @Query("search") burgerName: String)
    : List<BurgerResponse>
}