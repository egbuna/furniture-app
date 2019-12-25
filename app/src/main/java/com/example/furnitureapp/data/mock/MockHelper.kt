package com.example.furnitureapp.data.mock

import com.example.core.dagger.scope.FeatureScope
import com.example.core.model.HomeItem
import javax.inject.Inject

@FeatureScope
class MockHelper @Inject constructor() : MockHelperInterface {

    override fun mockPopularItems(): ArrayList<HomeItem> {
        val popularItems = ArrayList<HomeItem>()
        popularItems += HomeItem(
            name = "Table",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3300&q=80",
            price = "5000"
        )
        popularItems += HomeItem(
            name = "Chair",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3300&q=80",
            price = "4000"
        )
        popularItems += HomeItem(
            name = "Stool",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3300&q=80",
            price = "10000"
        )
        popularItems += HomeItem(
            name = "Desk",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=3300&q=80",
            price = "9000"
        )

        return popularItems
    }

    override fun mockNewArrivals(): ArrayList<HomeItem> {
        val newArrivals = ArrayList<HomeItem>()
        newArrivals += HomeItem(
            name = "Bed",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1507904953637-96429a46671a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1300&q=80",
            price = "65000"
        )
        newArrivals += HomeItem(
            name = "Couch",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1507904953637-96429a46671a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1300&q=80",
            price = "15000"
        )
        newArrivals += HomeItem(
            name = "Soufer",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1507904953637-96429a46671a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1300&q=80",
            price = "25000"
        )
        newArrivals += HomeItem(
            name = "Dinning Set",
            description = "All in on table",
            rating = "4.0",
            image = "https://images.unsplash.com/photo-1507904953637-96429a46671a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1300&q=80",
            price = "55000"
        )

        return newArrivals
    }
}