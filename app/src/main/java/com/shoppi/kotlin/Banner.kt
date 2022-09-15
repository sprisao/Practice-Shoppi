package com.shoppi.kotlin

import com.google.gson.annotations.SerializedName
import java.time.ZoneId

data class Banner(
    @SerializedName("background_image_url") val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
   @SerializedName("product_detail") val productDetail: ProductDetail,
    )

data class BannerBadge(
   @SerializedName("background_color") val backgroundColor: String, val label: String
)

data class ProductDetail(
    val label: String,
   @SerializedName("brand_name") val brandName: String,
    val price: Int,
   @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String,
   @SerializedName("discount_rate") val discountRate: Int,
   @SerializedName("product_id") val productId: String
)
