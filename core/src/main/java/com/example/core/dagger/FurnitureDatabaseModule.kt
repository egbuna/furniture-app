package com.example.core.dagger

import android.app.Application
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.AppRoomDatabase
import com.example.core.data.dao.FurnitureDao
import dagger.Module
import dagger.Provides

@Module
class FurnitureDatabaseModule {

    @FeatureScope
    @Provides
    fun provideDatabase(app: Application): AppRoomDatabase = AppRoomDatabase.buildDefault(app)

    @FeatureScope
    @Provides
    fun provideFurnitureDao(db: AppRoomDatabase): FurnitureDao = db.furnitureDao()
}