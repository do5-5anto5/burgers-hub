package com.example.burgershub.domain.model

import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse

data class Burger(
    val id: Int? = null,
    val name: String? = null,
    val images: List<ImageResponse>? = null,
    val desc: String? = null,
    val ingredients: List<IngredientResponse>? = null,
    val price: Float? = null,
    val veg: Boolean? = null
)