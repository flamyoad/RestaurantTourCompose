package com.example.restauranttourcompose.model

data class RestaurantDetail(
    val type: String,
    val address: Address,
    val rating: Double,
    val isOpenNow: Boolean,
)
