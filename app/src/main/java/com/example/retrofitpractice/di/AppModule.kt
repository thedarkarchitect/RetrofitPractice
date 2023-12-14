package com.example.retrofitpractice.di

import com.example.retrofitpractice.data.remote.ProductsApi
import com.example.retrofitpractice.data.repository.ProductRepositoryImpl
import com.example.retrofitpractice.domain.repository.ProductRepository
import com.example.retrofitpractice.utils.Constants.BASE_URL
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

object AppModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Singleton
    @Provides
    fun provideRetrofitApi(
        api: ProductsApi
    ): ProductsApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(api::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        api: ProductsApi
    ): ProductRepository {
        return ProductRepositoryImpl(api)
    }

}