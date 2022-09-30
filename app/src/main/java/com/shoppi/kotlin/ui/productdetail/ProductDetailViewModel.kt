package com.shoppi.kotlin.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.kotlin.model.Product
import com.shoppi.kotlin.repository.cart.CartRepository
import com.shoppi.kotlin.repository.productdetail.ProductDetailRepository
import com.shoppi.kotlin.ui.common.Event
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    private val productDetailRepository: ProductDetailRepository,
    private val cartRepository: CartRepository
) : ViewModel() {

    private val _productDetail = MutableLiveData<Product>()
    val productDetail: LiveData<Product> = _productDetail


    private val _addCartEvent = MutableLiveData<Event<Unit>>()
    val addCartEvent: LiveData<Event<Unit>> = _addCartEvent

    fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail =
                productDetailRepository.getProductDetail(productId)
            _productDetail.value = productDetail
        }
    }

    fun addCart(product: Product) {
        viewModelScope.launch {
            cartRepository.addCartItem(product)
            _addCartEvent.value = Event(Unit)
        }
    }
}
