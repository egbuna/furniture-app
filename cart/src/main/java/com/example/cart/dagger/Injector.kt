package com.example.cart.dagger

import com.example.cart.ui.CartFragment
import com.example.core.CoreApplication
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.DaggerCoreComponent

fun inject(fragment: CartFragment) {
    DaggerCartComponent
        .factory()
        .coreComponent((fragment.activity?.applicationContext as CoreApplication).getCoreComponent)
        .inject(fragment)
}