package com.shoppi.kotlin.repository.categorydetail

import com.shoppi.kotlin.model.CategoryDetail
import com.shoppi.kotlin.network.ApiClient

class CategoryDetailRemoteDataSource(private val api: ApiClient) :
    CategoryDetailDataSource {
    override suspend fun getCategoryDetail(): CategoryDetail {
        return api.getCategoryDetail()
    }

}
