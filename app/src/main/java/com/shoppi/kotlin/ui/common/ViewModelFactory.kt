package com.shoppi.kotlin.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.kotlin.AssetLoader
import com.shoppi.kotlin.network.ApiClient
import com.shoppi.kotlin.repository.CategoryRemoteDataSource
import com.shoppi.kotlin.repository.CategoryRepository
import com.shoppi.kotlin.repository.HomeAssetDataSource
import com.shoppi.kotlin.repository.HomeRepository
import com.shoppi.kotlin.ui.category.CategoryViewModel
import com.shoppi.kotlin.ui.home.HomeViewModel
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
                CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
            CategoryViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}