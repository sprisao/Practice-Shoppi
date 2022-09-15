package com.shoppi.kotlin

import com.google.gson.annotations.SerializedName

data class Title(
    val text: String,
    @SerializedName("top_banners") val iconUrl: String
)
