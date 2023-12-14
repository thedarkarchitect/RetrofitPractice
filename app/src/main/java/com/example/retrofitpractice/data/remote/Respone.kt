package com.example.retrofitpractice.data.remote


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Respone(
    @SerialName("limit")
    val limit: Int,
    @SerialName("products")
    val products: List<Product>,
    @SerialName("skip")
    val skip: Int,
    @SerialName("total")
    val total: Int
)