package com.shoppi.kotlin.repository.productdetail

import com.shoppi.kotlin.model.Product

class ProductDetailRepository(private val remoteDataSource: ProductDetailRemoteDataSource) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }

}
