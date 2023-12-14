package com.example.retrofitpractice.data.remote

import com.example.retrofitpractice.data.remote.model.Product
import retrofit2.http.GET

interface ProductsApi {
    @GET("products")
    suspend fun getProductsList(

    ): List<Product>
}