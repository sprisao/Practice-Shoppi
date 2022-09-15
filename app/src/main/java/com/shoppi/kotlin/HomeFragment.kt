package com.shoppi.kotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.google.gson.Gson
import org.json.JSONObject

class HomeFragment : Fragment() {

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


        val assetLoader = AssetLoader()
        val homeJsonString =
            assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeJsonString ?: "")

        if (homeJsonString != null) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

            toolbarTitle.text = homeData.title.text

            Glide.with(this).load(homeData.title.iconUrl).into(toolbarIcon)

            viewpager.adapter = HomeBannerAdapter().apply {
                submitList(homeData.topBanners)
            }
        }

    }
}
