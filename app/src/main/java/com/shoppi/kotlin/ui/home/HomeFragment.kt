package com.shoppi.kotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.shoppi.kotlin.R
import com.shoppi.kotlin.databinding.FragmentHomeBinding
import com.shoppi.kotlin.ui.common.ViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels {
        ViewModelFactory(
            requireContext()
        )
    }
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*이 작업은 필수*/
        binding.lifecycleOwner = viewLifecycleOwner

        /*binding을 통해 데이터 불러오기 적용*/
        setToolbar()

        /* 'viewpager'가 반복되므로 'with'함수를 통해 반복을 없앤다*/
        setTopBanners()

    }

    private fun setToolbar() {
        viewModel.title.observe(
            viewLifecycleOwner
        ) { title ->
            binding.title = title
        }
    }

    private fun setTopBanners() {
        with(binding.vpHomeBanner) {
            adapter = HomeBannerAdapter().apply {
                viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                    submitList(banners)
                }
            }

            val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
            val pageMargin =
                resources.getDimension(R.dimen.viewpager_item_margin)

            val screenWidth = resources.displayMetrics.widthPixels
            val offset = screenWidth - pageWidth - pageMargin

            offscreenPageLimit = 3
            setPageTransformer { page, position ->
                page.translationX = position * -offset
            }

            TabLayoutMediator(
                binding.vpHomeBannerIndicator, this
            ) { tab, position -> tab.text = "" }.attach()
        }
    }

}
