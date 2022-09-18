package com.shoppi.kotlin.repository.category

import com.shoppi.kotlin.model.Category

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {
    suspend fun getCategories(): List<Category> {
        return remoteDataSource.getCategories()
    }

}
