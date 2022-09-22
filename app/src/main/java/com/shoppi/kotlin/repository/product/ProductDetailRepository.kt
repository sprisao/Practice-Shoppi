package com.shoppi.kotlin.repository.product

import com.shoppi.kotlin.model.Product

class ProductDetailRepository(private val remoteDataSource: ProductDetailRemoteDataSource) {

    suspend fun getProductDetail(): Product {
        return remoteDataSource.getProductDetail()
    }

}
