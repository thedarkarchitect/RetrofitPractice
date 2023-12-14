package com.example.retrofitpractice.data.repository

import com.example.retrofitpractice.data.remote.ProductsApi
import com.example.retrofitpractice.data.remote.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import com.example.retrofitpractice.utils.Results


class ProductRepositoryImpl(
    private val api: ProductsApi
): ProductRepository {
    override suspend fun getProductList(): Flow<Results<List<Product>>> = flow {
        try {
            val productsFromApi = api.getProductsList()
            emit(Results.Success(data = productsFromApi.products))
        } catch (e: IOException){
            e.printStackTrace()
            emit(Results.Error(message = "Error Loading products", data = null))
            return@flow
        }catch (e: HttpException){
            e.printStackTrace()
            emit(Results.Error(message = "Error Loading products", data = null))
            return@flow
        }catch (e: Exception){
            e.printStackTrace()
            emit(Results.Error(message = "Error Loading products", data = null))
            return@flow
        }
    }

}