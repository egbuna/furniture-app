package com.example.core.dagger

import android.app.Application
import com.google.gson.Gson
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Component(modules = [CoreDataModule::class])
@Singleton
interface CoreComponent {

    @Component.Builder
    interface Builder {
        //fun application(): Application
        fun coreDataModule(coreDataModule: CoreDataModule): Builder
        fun build(): CoreComponent
    }

    fun provideGson(): Gson
    fun provideGsonConverterFactory(): GsonConverterFactory
    fun provideOkhhtp(): OkHttpClient
}