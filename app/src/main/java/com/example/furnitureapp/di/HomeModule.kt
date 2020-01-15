package com.example.furnitureapp.di

import androidx.lifecycle.ViewModelProviders
import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.ui.home.HomeViewModel
import com.example.furnitureapp.ui.home.HomeViewModelFactory
import com.example.furnitureapp.ui.home.living_room.LivingRoomFragment
import dagger.Module
import dagger.Provides

@Module
class HomeModule(private val T: LivingRoomFragment) {

    @FeatureScope
    @Provides
    fun provideHomeViewModel(factory: HomeViewModelFactory):
            HomeViewModel = ViewModelProviders.of(T, factory).get(HomeViewModel::class.java)

}