package com.example.cart.dagger

import android.app.Application
import android.content.Context
import com.example.cart.ui.CartFragment
import com.example.core.dagger.BaseComponent
import com.example.core.dagger.CoreComponent
import com.example.core.dagger.FurnitureDatabaseModule
import com.example.core.dagger.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(modules = [FurnitureDatabaseModule::class])
interface CartComponent: BaseComponent<CartFragment> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun furnitureDatabaseModule(furnitureDatabaseModule: FurnitureDatabaseModule): Builder
        fun build(): CartComponent
    }
}