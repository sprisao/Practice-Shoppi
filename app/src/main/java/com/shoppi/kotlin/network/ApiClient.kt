package com.shoppi.kotlin.network

import com.shoppi.kotlin.model.Category
import com.shoppi.kotlin.model.CategoryDetail
import com.shoppi.kotlin.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("fashion_female.json")
    suspend fun getCategoryDetail(): CategoryDetail

    @GET("products.json")
    suspend fun getProductDetail(): Product

    companion object {

        private const val baseUrl =
            "https://shoppi-kotlin-app-default-rtdb.asia-southeast1.firebasedatabase.app/"

        fun create(): ApiClient {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client =
                OkHttpClient.Builder().addInterceptor(logger).build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl).client(client).build()
            return retrofit.create(ApiClient::class.java)
        }
    }
}
