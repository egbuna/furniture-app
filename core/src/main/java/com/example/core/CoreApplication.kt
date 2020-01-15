package com.example.core

import android.app.Application
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.DaggerCoreComponent

class CoreApplication : Application() {

    val getCoreComponent: CoreComponent by lazy {
        DaggerCoreComponent
            .factory().build(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}