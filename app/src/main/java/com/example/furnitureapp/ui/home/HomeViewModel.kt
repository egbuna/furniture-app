package com.example.furnitureapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.model.CartHomeItem
import javax.inject.Inject

class HomeViewModel @Inject constructor(val homeRepository: HomeRepository) : ViewModel() {

    val furnitureItems = homeRepository.getSaveAndFetchFurniture().asLiveData()
}