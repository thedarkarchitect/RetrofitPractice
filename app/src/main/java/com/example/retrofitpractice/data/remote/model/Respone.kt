package com.example.retrofitpractice.data.remote.model





data class Respone(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)