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
import com.shoppi.kotlin.ui.common.ViewModelFactory

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels {
        ViewModelFactory(
            requireContext()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbarIcon = view.findViewById<ImageView>(R.id.iv_home_icon)
        val toolbarTitle = view.findViewById<TextView>(R.id.tv_home_title)
        val viewpager = view.findViewById<ViewPager2>(R.id.vp_home_banner)


        viewModel.title.observe(
            viewLifecycleOwner
        ) { title ->
            toolbarTitle.text = title.text
            Glide.with(this).load(title.iconUrl).into(toolbarIcon)
        }


        viewpager.adapter = HomeBannerAdapter().apply {
            viewModel.topBanners.observe(viewLifecycleOwner) { banners ->
                submitList(banners)
            }
        }

        val pageWidth = resources.getDimension(R.dimen.viewpager_item_width)
        val pageMargin = resources.getDimension(R.dimen.viewpager_item_margin)

        val screenWidth = resources.displayMetrics.widthPixels
        val offset = screenWidth - pageWidth - pageMargin

        viewpager.offscreenPageLimit = 3
        viewpager.setPageTransformer { page, position ->
            page.translationX = position * -offset
        }

        TabLayoutMediator(
            view.findViewById(R.id.vp_home_banner_indicator), viewpager
        ) { tab, position -> tab.text = "" }.attach()
    }

}
