package com.example.furnitureapp.di

import android.app.Application
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class, MockModule::class])
interface AppComponent : BaseComponent<LivingRoomFragment>{

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }
}