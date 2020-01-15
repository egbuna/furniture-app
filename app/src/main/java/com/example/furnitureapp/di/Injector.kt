package com.example.furnitureapp.di

import android.app.Activity
import com.example.furnitureapp.MyApplication
import com.example.furnitureapp.ui.detail.DetailFragment
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment

fun inject(application: MyApplication, fragment: LivingRoomFragment) {
    DaggerAppComponent.builder()
        .application(application)
        .build()
        .inject(fragment)
}

fun inject(application: MyApplication, fragment: DetailFragment) {
    DaggerDetailAppComponent.builder()
        .application(application)
        .build()
        .inject(fragment)
}