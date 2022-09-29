package com.shoppi.kotlin.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoppi.kotlin.databinding.ItemCartSectionBinding
import com.shoppi.kotlin.databinding.ItemCartSubSectionBinding
import com.shoppi.kotlin.model.CartHeader
import com.shoppi.kotlin.model.CartItem
import com.shoppi.kotlin.model.CartProduct
import okhttp3.internal.notify

private const val TYPE_SECTION = 0
private const val TYPE_SUB_SECTION = 1

class CartAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val cartProducts = mutableListOf<CartProduct>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_SECTION -> {
                val binding = ItemCartSectionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                SectionViewHolder(binding)
            }

            TYPE_SUB_SECTION -> {
                val binding = ItemCartSubSectionBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
                SubSectionViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Unknown viewType: $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (cartProducts[position]) {
            is CartHeader -> TYPE_SECTION
            is CartItem -> TYPE_SUB_SECTION
        }
    }

    override fun getItemCount(): Int {
        return cartProducts.size
    }
    fun submitHeaderAndItemList(items: List<CartItem>) {
        val itemGroups = items.groupBy { it.brandName }
        val products = mutableListOf<CartProduct>()

        itemGroups.entries.forEach { entry ->
            products.add(CartHeader(entry.key))
            products.addAll(entry.value)
        }

        notifyItemRangeInserted(cartProducts.size, products.size)
    }
    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder, position: Int
    ) {
        when (holder) {
            is SectionViewHolder -> holder.bind(cartProducts[position] as CartHeader)
            is SubSectionViewHolder -> holder.bind(cartProducts[position] as CartItem)
        }
    }


    class SectionViewHolder(private val binding: ItemCartSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartHeader: CartHeader) {
            binding.header = cartHeader
            binding.executePendingBindings()
        }
    }


    class SubSectionViewHolder(private val binding: ItemCartSubSectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cartItem: CartItem) {
            binding.item = cartItem
            binding.executePendingBindings()
        }
    }

}
