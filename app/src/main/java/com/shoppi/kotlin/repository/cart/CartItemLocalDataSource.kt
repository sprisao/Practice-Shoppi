package com.shoppi.kotlin.repository.cart

import com.shoppi.kotlin.database.CartItemDao
import com.shoppi.kotlin.model.CartItem

class CartItemLocalDataSource(private val dao: CartItemDao) :

    CartItemDataSource {
    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }

}
