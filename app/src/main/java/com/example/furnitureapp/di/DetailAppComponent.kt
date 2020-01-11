package com.example.furnitureapp.di

import android.app.Application
import com.example.cart.dagger.CartComponent
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.FurnitureDatabaseModule
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.detail.DetailFragment
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class, CoreDataModule::class], dependencies = [CoreComponent::class])
interface DetailAppComponent : BaseComponent<DetailFragment> {

    @Component.Builder
    interface Builder {
        fun coreModule(coreDataModule: CoreDataModule): Builder
        fun furnitureDatabaseModule(furnitureDatabaseModule: FurnitureDatabaseModule): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): DetailAppComponent
    }
}