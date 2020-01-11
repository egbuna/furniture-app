package com.example.furnitureapp.di

import android.app.Application
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.DaggerCoreComponent
import com.example.core.dagger.FurnitureDatabaseModule
import com.example.furnitureapp.MyApplication
import com.example.furnitureapp.ui.detail.DetailFragment
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment

fun inject(application: MyApplication, fragment: LivingRoomFragment) {
    DaggerAppComponent.builder()
        .coreDataModule(CoreDataModule(application))
        .furnitureDatabaseModule(FurnitureDatabaseModule(application))
        .build()
        .inject(fragment)
}

fun inject(application: MyApplication, fragment: DetailFragment) {
    DaggerDetailAppComponent.builder()
        .coreModule(CoreDataModule(application))
        .furnitureDatabaseModule(FurnitureDatabaseModule(application))
        .coreComponent(application.getCoreComponent)
        .build()
        .inject(fragment)
}

fun inject(application: Application) {
    DaggerCoreComponent.builder()
        .coreDataModule(CoreDataModule(application))
        .build()
}