package com.example.core.dagger

import android.app.Application
import android.content.Context
import android.os.Build
import com.example.core.CoreApplication
import com.example.core.data.AppRoomDatabase
import com.example.core.data.dao.FurnitureDao
import com.google.gson.Gson
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [CoreDataModule::class, CoreRoomModule::class, CoreApplicationModule::class])
@Singleton
interface CoreComponent {

    @Component.Factory
    interface Builder {
        fun build(@BindsInstance application: Context): CoreComponent
    }

    fun provideGson(): Gson
    fun provideGsonConverterFactory(): GsonConverterFactory
    fun provideOkhhtp(): OkHttpClient
    fun provideFurnitureDatabase(): AppRoomDatabase
    fun provideDao(): FurnitureDao
}