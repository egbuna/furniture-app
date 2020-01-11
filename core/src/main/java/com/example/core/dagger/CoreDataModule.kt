package com.example.core.dagger

import android.app.Application
import android.content.Context
import com.example.core.BuildConfig
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.AppRoomDatabase
import com.example.core.data.dao.FurnitureDao
import com.google.gson.Gson
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class CoreDataModule(val application: Application) {

    @Provides
    @FeatureScope
    fun provideContext(): Context = application

    @Provides
    @FeatureScope
    fun provideApplication(): Application = application

//    @Provides
//    @FeatureScope
//    fun provideCoreApplication()

    @Provides
    fun provideOkhttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    fun provideOkhttpInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    private fun createRetrofit(
        okhttpClient: Lazy<OkHttpClient>,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ENDPOINT)
            .callFactory(okhttpClient.get())
            .addConverterFactory(converterFactory)
            .build()
    }

    private val ENDPOINT = ""

    @FeatureScope
    @Provides
    fun provideDatabase(app: Application): AppRoomDatabase = AppRoomDatabase.buildDefault(application)

    @FeatureScope
    @Provides
    fun provideFurnitureDao(db: AppRoomDatabase): FurnitureDao = db.furnitureDao()

}