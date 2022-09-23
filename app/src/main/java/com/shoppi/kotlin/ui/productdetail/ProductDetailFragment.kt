package com.shoppi.kotlin.ui.productdetail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shoppi.kotlin.R
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

        viewModel.productDetail.observe(viewLifecycleOwner) { productDetail ->
            Log.e("Data", binding.product.toString())
            binding.product = productDetail
        }

        val productId = requireArguments().getString(KEY_PRODUCT_ID)
        Log.d("ProductDetailFragment", "productID=$productId")
    }
}
