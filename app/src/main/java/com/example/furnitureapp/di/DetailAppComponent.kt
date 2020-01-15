package com.example.furnitureapp.di

import android.app.Application
import com.example.cart.dagger.CartComponent
import com.example.core.dagger.*
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.detail.DetailFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@FeatureScope
@Component(dependencies = [CoreComponent::class])
interface DetailAppComponent : BaseComponent<DetailFragment> {

    @Component.Factory
    interface Builder {
        fun coreComponent(coreComponent: CoreComponent): DetailAppComponent
    }
}