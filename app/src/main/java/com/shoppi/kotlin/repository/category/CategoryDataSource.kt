package com.shoppi.kotlin.repository.category

import com.shoppi.kotlin.model.Category

interface CategoryDataSource {
    suspend  fun getCategories(): List<Category>
}
