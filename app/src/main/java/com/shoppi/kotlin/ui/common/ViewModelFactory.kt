package com.shoppi.kotlin.ui.common

import android.app.Service
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.kotlin.AssetLoader
import com.shoppi.kotlin.ServiceLocator
import com.shoppi.kotlin.network.ApiClient
import com.shoppi.kotlin.repository.category.CategoryRemoteDataSource
import com.shoppi.kotlin.repository.category.CategoryRepository
import com.shoppi.kotlin.repository.categorydetail.CategoryDetailRemoteDataSource
import com.shoppi.kotlin.repository.categorydetail.CategoryDetailRepository
import com.shoppi.kotlin.repository.home.HomeAssetDataSource
import com.shoppi.kotlin.repository.home.HomeRepository
import com.shoppi.kotlin.repository.productdetail.ProductDetailRemoteDataSource
import com.shoppi.kotlin.repository.productdetail.ProductDetailRepository
import com.shoppi.kotlin.ui.category.CategoryViewModel
import com.shoppi.kotlin.ui.categorydetail.CategoryDetailViewModel
import com.shoppi.kotlin.ui.home.HomeViewModel
import com.shoppi.kotlin.ui.productdetail.ProductDetailViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository =
                HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            val repository =
                CategoryRepository(CategoryRemoteDataSource(ServiceLocator.provideApiClient()))
            CategoryViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryDetailViewModel::class.java)) {
            val repository = CategoryDetailRepository(
                CategoryDetailRemoteDataSource(ServiceLocator.provideApiClient())
            )
            CategoryDetailViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProductDetailViewModel::class.java)) {
            val repository = ProductDetailRepository(
                ProductDetailRemoteDataSource(ServiceLocator.provideApiClient())
            )
            ProductDetailViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}
