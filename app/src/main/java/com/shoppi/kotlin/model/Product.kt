package com.shoppi.kotlin.model

import com.google.gson.annotations.SerializedName

data class Product(
    val label: String,
    @SerializedName("brand_name") val brandName: String?,
    val price: Int,
    @SerializedName("thumbnail_image_url") val thumbnailImageUrl: String?,
    @SerializedName("representative_image_url") val representativeImageUrl: String?,
    @SerializedName("discount_rate") val discountRate: Int,
    val type: String,
    val description: Description,
    @SerializedName("product_id") val productId: String
)

data class Description(
    val id: String,
    @SerializedName("image_url") val imgUrl: String,
)


