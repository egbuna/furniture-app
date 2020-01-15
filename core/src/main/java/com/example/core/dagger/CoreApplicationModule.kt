package com.example.core.dagger

import android.app.Application
import com.example.core.CoreApplication
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class CoreApplicationModule {

    @Binds
    @Singleton
    abstract fun bindApplication(application: CoreApplication): Application
}