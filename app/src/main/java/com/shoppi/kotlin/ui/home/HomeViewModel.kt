package com.shoppi.kotlin.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoppi.kotlin.model.Banner
import com.shoppi.kotlin.model.Title
import com.shoppi.kotlin.repository.home.HomeRepository
import com.shoppi.kotlin.ui.common.Event

class HomeViewModel(private val homeRepository: HomeRepository) :
        ViewModel() {

    private val _title = MutableLiveData<Title>()
    val title: LiveData<Title> = _title

    private val _topBanners = MutableLiveData<List<Banner>>()
    val topBanners: LiveData<List<Banner>> = _topBanners

    private val _openProductDetailEvent = MutableLiveData<Event<String>>()
    val openProductDetailEvent: LiveData<Event<String>> =
        _openProductDetailEvent

    init {
        loadHomeData()
    }

    fun openProductDetail(productId: String) {
        _openProductDetailEvent.value = Event(productId)
    }

    private fun loadHomeData() {
        val homeData = homeRepository.getHomeData()
        homeData?.let { received_homeData ->
            _title.value = received_homeData.title
            _topBanners.value = received_homeData.topBanners
        }
    }
}
