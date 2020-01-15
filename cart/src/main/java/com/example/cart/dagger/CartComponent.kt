package com.example.cart.dagger

import android.app.Application
import com.example.cart.ui.CartFragment
import com.example.core.dagger.*
import com.example.core.dagger.scope.FeatureScope
import dagger.BindsInstance
import dagger.Component

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface CartComponent: BaseComponent<CartFragment> {

    @Component.Factory
    interface Builder {
        fun coreComponent(coreComponent: CoreComponent): CartComponent
    }
}