package com.shoppi.kotlin

import java.time.ZoneId

data class Banner(
    val backgroundImageUrl: String,
    val badge: BannerBadge,
    val label: String,
    val productDetail: ProductDetail,
    )

data class BannerBadge(
    val backgroundColor: String, val label: String
)

data class ProductDetail(
    val label: String,
    val brandName: String,
    val price: Int,
    val thumbnailImageUrl: String,
    val discountRate: Int,
    val productId: String
)
