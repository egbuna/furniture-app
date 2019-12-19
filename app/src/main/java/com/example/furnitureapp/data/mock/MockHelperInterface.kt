package com.example.furnitureapp.data.mock

import com.example.core.model.HomeItem

interface MockHelperInterface {
    fun mockPopularItems(): ArrayList<HomeItem>
    fun mockNewArrivals(): ArrayList<HomeItem>
}