package com.example.retrofitpractice.data.remote

import com.example.retrofitpractice.data.remote.model.Responses
import retrofit2.Response
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProductsList(): Responses
}