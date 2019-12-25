package com.example.cart.dagger

import android.app.Application
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.AppRoomDatabase
import com.example.core.data.dao.FurnitureDao
import dagger.Module
import dagger.Provides

@Module
class CartDatabaseModule(private  val application: Application) {

    @FeatureScope
    @Provides
    fun provideDatabase(): AppRoomDatabase = AppRoomDatabase.buildDefault(application)

    @FeatureScope
    @Provides
    fun provideFurnitureDao(db: AppRoomDatabase): FurnitureDao = db.furnitureDao()
}