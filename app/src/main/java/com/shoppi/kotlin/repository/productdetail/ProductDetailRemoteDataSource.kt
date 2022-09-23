package com.shoppi.kotlin.repository.productdetail

import com.shoppi.kotlin.model.Product
import com.shoppi.kotlin.network.ApiClient

class ProductDetailRemoteDataSource(private val api: ApiClient) : ProductDetailDataSource {
    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}
