package com.shoppi.kotlin.model

import com.google.gson.annotations.SerializedName

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    @SerializedName("product_detail") val product: Product,
)

data class BannerBadge(
    @SerializedName("background_color") val backgroundColor: String,
    val label: String
)

