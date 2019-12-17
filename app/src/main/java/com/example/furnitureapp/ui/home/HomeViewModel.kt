package com.example.furnitureapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import javax.inject.Inject

class HomeViewModel @Inject constructor(homeRepository: HomeRepository) : ViewModel() {

    val furnitureItems = homeRepository.getSaveAndFetchFurniture().asLiveData()
}