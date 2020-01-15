package com.example.furnitureapp.di

import com.example.core.dagger.*
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment
import dagger.Component

@FeatureScope
@Component(modules = [MockModule::class], dependencies = [CoreComponent::class])
interface AppComponent : BaseComponent<LivingRoomFragment> {

    @Component.Factory
    interface Builder {
        fun coreComponent(coreComponent: CoreComponent): AppComponent
    }
}