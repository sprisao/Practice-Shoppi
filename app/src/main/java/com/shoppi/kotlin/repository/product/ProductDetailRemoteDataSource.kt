package com.shoppi.kotlin.repository.product

import com.shoppi.kotlin.model.Product
import com.shoppi.kotlin.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient) : ProductDetailDataSource {
    override suspend fun getProductDetail(): Product {
        return api.getProductDetail()
    }
}
