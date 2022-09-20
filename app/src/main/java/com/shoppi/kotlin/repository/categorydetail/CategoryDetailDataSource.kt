package com.shoppi.kotlin.repository.categorydetail

import com.shoppi.kotlin.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}
