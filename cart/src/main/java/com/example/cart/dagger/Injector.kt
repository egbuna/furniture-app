package com.example.cart.dagger

import android.app.Application
import com.example.cart.ui.CartFragment
import com.example.core.dagger.*

fun inject(fragment: CartFragment, application: Application) {
    DaggerCartComponent.builder()
        .coreComponent(getCoreComponent(application))
        .coreModule(CoreDataModule(application))
        .furnitureDatabaseModule(FurnitureDatabaseModule(application))
        .build()
        .inject(fragment)
}

fun getCoreComponent(application: Application): CoreComponent {
    return DaggerCoreComponent.builder()
            .coreDataModule(CoreDataModule(application))
            .build()
}