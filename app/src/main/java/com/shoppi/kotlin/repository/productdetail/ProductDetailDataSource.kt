package com.shoppi.kotlin.repository.productdetail

import com.shoppi.kotlin.model.Product

interface ProductDetailDataSource {
   suspend fun getProductDetail(productId: String): Product?
}
