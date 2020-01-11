package com.example.furnitureapp

import android.app.Activity
import android.app.Application
import android.content.Context
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.DaggerCoreComponent
import com.example.furnitureapp.di.AppComponent
import com.example.furnitureapp.di.DaggerAppComponent
import com.example.furnitureapp.di.inject

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    val getCoreComponent: CoreComponent by lazy {
        DaggerCoreComponent.builder()
            .coreDataModule(CoreDataModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        initializeCoreComponent()
    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as MyApplication).appComponent
    }


    private fun initializeCoreComponent() {
        inject(this)
    }
}