package com.example.cart.dagger

import android.app.Application
import android.content.Context
import com.example.cart.ui.CartFragment
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.CoreDataModule
import com.example.core.dagger.FurnitureDatabaseModule
import com.example.core.dagger.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class, CoreDataModule::class], dependencies = [CoreComponent::class])
interface CartComponent: BaseComponent<CartFragment> {

    @Component.Builder
    interface Builder {
        fun coreModule(coreDataModule: CoreDataModule): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun furnitureDatabaseModule(furnitureDatabaseModule: FurnitureDatabaseModule): Builder
        fun build(): CartComponent
    }
}