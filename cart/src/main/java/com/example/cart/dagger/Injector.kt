package com.example.cart.dagger

import android.app.Application
import com.example.cart.ui.CartFragment
import com.example.core.dagger.FurnitureDatabaseModule

fun inject(fragment: CartFragment, application: Application) {
    DaggerCartComponent.builder()
        .application(application)
        .furnitureDatabaseModule(FurnitureDatabaseModule())
        .build()
        .inject(fragment)
}