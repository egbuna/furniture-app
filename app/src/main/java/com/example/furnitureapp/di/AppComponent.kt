package com.example.furnitureapp.di

import android.app.Application
import com.example.cart.dagger.CartComponent
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.FurnitureDatabaseModule
import com.example.core.dagger.MockModule
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.MyApplication
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class, CoreDataModule::class, MockModule::class])
interface AppComponent : BaseComponent<LivingRoomFragment> {

    @Component.Builder
    interface Builder {
        fun coreDataModule(coreDataModule: CoreDataModule): Builder
        fun furnitureDatabaseModule(furnitureDatabaseModule: FurnitureDatabaseModule): Builder
        fun build(): AppComponent
    }
}