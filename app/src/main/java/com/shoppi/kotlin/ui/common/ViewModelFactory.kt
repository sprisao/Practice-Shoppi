package com.shoppi.kotlin.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shoppi.kotlin.AssetLoader
import com.shoppi.kotlin.repository.HomeAssetDataSource
import com.shoppi.kotlin.repository.HomeRepository
import com.shoppi.kotlin.ui.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository =
                HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}
