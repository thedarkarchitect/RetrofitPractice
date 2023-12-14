package com.example.retrofitpractice.data.remote.model





data class Responses(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)