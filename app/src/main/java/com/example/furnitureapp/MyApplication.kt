package com.example.furnitureapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.furnitureapp.di.AppComponent
import com.example.furnitureapp.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as MyApplication).appComponent
    }

    fun Activity.coreComponent() = MyApplication.coreComponent(this)
}