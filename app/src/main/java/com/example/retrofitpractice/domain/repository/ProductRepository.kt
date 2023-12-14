package com.example.retrofitpractice.domain.repository

import com.example.retrofitpractice.data.remote.model.Product
import kotlinx.coroutines.flow.Flow
import com.example.retrofitpractice.utils.Results

interface ProductRepository {
    suspend fun getProductList(): Flow<Results<List<Product>>>
}