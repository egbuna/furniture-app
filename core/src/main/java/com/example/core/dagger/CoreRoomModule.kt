package com.example.core.dagger

import android.app.Application
import android.content.Context
import com.example.core.CoreApplication
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.AppRoomDatabase
import com.example.core.data.dao.FurnitureDao
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreRoomModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Context): AppRoomDatabase = AppRoomDatabase.buildDefault(application)

    @Singleton
    @Provides
    fun provideFurnitureDao(db: AppRoomDatabase): FurnitureDao = db.furnitureDao()
}