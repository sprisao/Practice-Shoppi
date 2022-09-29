package com.shoppi.kotlin.repository.cart

import com.shoppi.kotlin.model.CartItem
import com.shoppi.kotlin.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(
    private val localDataSource: CartItemLocalDataSource,
    private val iODispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend fun addCartItem(product: Product) = withContext(iODispatcher) {
        val cartItem = CartItem(
            productId = product.productId,
            label = product.label,
            price = product.price,
            brandName = product.brandName ?: "",
            thumbnailImageUrl = product.thumbnailImageUrl ?: "",
            type = product.type ?: "",
            amount = 1
        )
        localDataSource.addCartItem(cartItem)
    }

    suspend fun getCartItems(): List<CartItem> {
        return withContext(iODispatcher) {
            localDataSource.getCartItems()
        }
    }
}
