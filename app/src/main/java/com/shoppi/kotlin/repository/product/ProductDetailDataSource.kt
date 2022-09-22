package com.shoppi.kotlin.repository.product

import com.shoppi.kotlin.model.Product

interface ProductDetailDataSource {
   suspend fun getProductDetail(): Product?
}
