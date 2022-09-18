package com.shoppi.kotlin.repository

import com.shoppi.kotlin.model.Category

interface CategoryDataSource {
    suspend  fun getCategories(): List<Category>
}
