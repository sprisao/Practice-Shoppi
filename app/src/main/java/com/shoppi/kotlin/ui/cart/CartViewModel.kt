package com.shoppi.kotlin.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.kotlin.model.CartItem

class CartViewModel: ViewModel() {
    private val _items = MutableLiveData<List<CartItem>>()
    val items : LiveData<List<CartItem>> =_items

    fun loadCartItem(){
        _items.value
    }
}
