package com.example.furnitureapp.di

import com.example.core.CoreApplication
import com.example.furnitureapp.ui.detail.DetailFragment
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment

fun inject(fragment: LivingRoomFragment) {
    DaggerAppComponent.factory()
        .coreComponent((fragment.activity?.applicationContext as CoreApplication).getCoreComponent)
        .inject(fragment)
}

fun inject(fragment: DetailFragment) {
    DaggerDetailAppComponent.factory()
        .coreComponent((fragment.activity?.applicationContext as CoreApplication).getCoreComponent)
        .inject(fragment)
}