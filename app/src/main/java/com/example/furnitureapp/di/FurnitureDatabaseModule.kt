package com.example.furnitureapp.di

import android.app.Application
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.data.local.AppRoomDatabase
import com.example.furnitureapp.data.local.dao.FurnitureDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FurnitureDatabaseModule {

    @FeatureScope
    @Provides
    fun provideDatabase(app: Application): AppRoomDatabase = AppRoomDatabase.buildDefault(app)

    @FeatureScope
    @Provides
    fun provideFurnitureDao(db: AppRoomDatabase): FurnitureDao = db.furnitureDao()
}