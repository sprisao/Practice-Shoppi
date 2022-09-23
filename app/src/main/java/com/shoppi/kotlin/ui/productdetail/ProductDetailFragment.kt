package com.shoppi.kotlin.ui.productdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shoppi.kotlin.common.KEY_PRODUCT_ID
import com.shoppi.kotlin.databinding.FragmentProductDetailBinding
import com.shoppi.kotlin.ui.common.ViewModelFactory

class ProductDetailFragment : Fragment() {

    private val viewModel: ProductDetailViewModel by viewModels {
        ViewModelFactory(
            requireContext()
        )
    }

    private lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        requireArguments().getString(KEY_PRODUCT_ID)?.let { productId ->
            setLayout(productId)
        }
    }

    private fun setLayout(
        productId: String,
    ) {
        viewModel.loadProductDetail(productId)
        val descriptionAdapter = ProductDescriptionAdapter()
        binding.rvProductDetail.adapter = descriptionAdapter
        viewModel.productDetail.observe(viewLifecycleOwner) { product ->
            binding.product = product
            descriptionAdapter.submitList(product.descriptions)
        }
    }
}
