package com.shoppi.kotlin.ui.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.shoppi.kotlin.R
import java.text.DecimalFormat

@BindingAdapter("priceAmount")
fun applyPriceFormat(view: TextView, price: Int) {
    val decimalFormat = DecimalFormat("#,###")
    view.text = view.context.getString(
        R.string.unit_discount_currency, decimalFormat.format(price)
    )
}

@BindingAdapter("priceAmount", "discountRate")
fun applyPriceDiscountRate(view: TextView, price: Int, discountRate: Int) {
    val discountPrice = price * (100 - discountRate) / 100
    applyPriceFormat(view, discountPrice)
}
