package com.example.cart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.model.CartHomeItem
import javax.inject.Inject

class CartViewModel @Inject constructor(private val cartRepository: CartRepository) : ViewModel() {

    fun getAllCartItem(): LiveData<List<CartHomeItem>> = cartRepository.getAllCartItem().asLiveData()
}