package com.example.core.mock

import com.example.core.model.HomeItem

interface MockHelperInterface {
    fun mockPopularItems(): ArrayList<HomeItem>
    fun mockNewArrivals(): ArrayList<HomeItem>
}