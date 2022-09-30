package com.shoppi.kotlin.repository.cart

import com.shoppi.kotlin.model.CartItem


interface CartItemDataSource {

   suspend fun addCartItem(cartItem: CartItem)


   suspend fun getCartItems(): List<CartItem>

}
