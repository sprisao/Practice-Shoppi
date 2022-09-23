package com.shoppi.kotlin.ui.productdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shoppi.kotlin.model.Product
import com.shoppi.kotlin.repository.productdetail.ProductDetailRepository
import kotlinx.coroutines.launch

class ProductDetailViewModel(private val productDetailRepository: ProductDetailRepository) :
    ViewModel() {

    private val _productDetail = MutableLiveData<Product>()
    val productDetail: LiveData<Product> = _productDetail


     fun loadProductDetail(productId: String) {
        viewModelScope.launch {
            val productDetail = productDetailRepository.getProductDetail(productId)
            _productDetail.value = productDetail
        }
    }
}
