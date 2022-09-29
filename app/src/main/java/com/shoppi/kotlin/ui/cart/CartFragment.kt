package com.shoppi.kotlin.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.shoppi.kotlin.R
import com.shoppi.kotlin.databinding.FragmentCartBinding
import com.shoppi.kotlin.ui.common.ViewModelFactory

class CartFragment: Fragment() {
    private val viewModel: CartViewModel by viewModels{ ViewModelFactory(requireContext())}
    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
    setListAdapter()
    }

    private fun setListAdapter() {
        val cartAdapter = CartAdapter()
        binding.rvCartItems.adapter = CartAdapter()
        viewModel.items.observe(viewLifecycleOwner){cartItems->
            cartAdapter.submitHeaderAndItemList(cartItems)
        }
    }
}
