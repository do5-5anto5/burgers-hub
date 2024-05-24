package com.example.burgershub.data.mapper

import com.example.burgershub.data.model.BurgerResponse
import com.example.burgershub.data.model.ImageResponse
import com.example.burgershub.data.model.IngredientResponse
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.domain.model.Image
import com.example.burgershub.domain.model.Ingredient

fun BurgerResponse.toDomain() = Burger(
    name = this.name,
    price = this.price,
    desc = this.desc,
    id = this.id,
    images = this.images?.map {it.toDomain() },
    ingredients = this.ingredients?.map {it.toDomain() },
    veg = this.veg
)

fun ImageResponse.toDomain() = Image(
    lg = this.lg,
    sm = this.sm
)

fun IngredientResponse.toDomain() = Ingredient(
    id = this.id,
    img = this.img,
    name = this.name
)