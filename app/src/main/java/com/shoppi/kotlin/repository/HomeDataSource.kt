package com.shoppi.kotlin.repository

import com.shoppi.kotlin.model.HomeData

interface HomeDataSource {
    fun getHomeData(): HomeData?
}
