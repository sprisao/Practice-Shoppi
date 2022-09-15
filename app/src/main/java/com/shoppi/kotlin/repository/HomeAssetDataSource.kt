package com.shoppi.kotlin.repository

import com.google.gson.Gson
import com.shoppi.kotlin.AssetLoader
import com.shoppi.kotlin.model.HomeData

class HomeAssetDataSource(private val assetLoader: AssetLoader) :
    HomeDataSource {
    private val gson = Gson()
    override fun getHomeData(): HomeData? {
        val homeJsonString = assetLoader.getJsonString("home.json")
        return assetLoader.getJsonString("home.json")?.let { homeJsonString ->
            gson.fromJson(homeJsonString, HomeData::class.java)
        }
    }
}
