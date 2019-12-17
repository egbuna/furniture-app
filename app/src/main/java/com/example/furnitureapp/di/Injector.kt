package com.example.furnitureapp.di

import com.example.furnitureapp.MyApplication
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment

fun LivingRoomFragment.inject(application: MyApplication) {
    DaggerAppComponent.builder()
        .application(application)
        .build()
        .inject(this)
}