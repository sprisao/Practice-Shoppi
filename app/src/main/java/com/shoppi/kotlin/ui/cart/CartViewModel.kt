package com.shoppi.kotlin.ui.cart

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.kotlin.model.CartItem
import com.shoppi.kotlin.repository.cart.CartRepository
import kotlinx.coroutines.launch

class CartViewModel(private val cartRepository: CartRepository): ViewModel() {
    private val _items = MutableLiveData<List<CartItem>>()
    val items : LiveData<List<CartItem>> =_items


    init {
        loadCartItem()
    }
    private fun loadCartItem(){
        viewModelScope.launch {
            _items.value = cartRepository.getCartItems()
        }
    }
}
