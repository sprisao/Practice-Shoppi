package com.shoppi.kotlin.repository

import com.shoppi.kotlin.model.Category
import com.shoppi.kotlin.network.ApiClient


class CategoryRemoteDataSource(private val apiClient: ApiClient) :CategoryDataSource{
    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}
