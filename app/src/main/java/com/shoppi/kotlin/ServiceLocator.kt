package com.shoppi.kotlin

import com.shoppi.kotlin.network.ApiClient

object ServiceLocator {
    private var apiClient: ApiClient? = null

    fun provideApiClient(): ApiClient {
        return apiClient ?: kotlin.run {
            ApiClient.create().also {
                apiClient = it
            }
        }
    }

}
