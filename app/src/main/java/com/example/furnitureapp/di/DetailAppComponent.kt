package com.example.furnitureapp.di

import android.app.Application
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.detail.DetailFragment
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class])
interface DetailAppComponent : BaseComponent<DetailFragment> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): DetailAppComponent
    }
}