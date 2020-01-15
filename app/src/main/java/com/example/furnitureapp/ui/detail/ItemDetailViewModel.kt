package com.example.furnitureapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.model.CartHomeItem
import javax.inject.Inject

class ItemDetailViewModel @Inject constructor(private val homeRepository: ItemDetailRepository) : ViewModel() {

    fun saveItemToCart(cartHomeItem: CartHomeItem) = homeRepository.saveToCart(cartHomeItem)

    fun getAllCartItem(): LiveData<List<CartHomeItem>> = homeRepository.getAllCartItem().asLiveData()
}