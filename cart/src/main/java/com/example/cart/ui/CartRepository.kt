package com.example.cart.ui

import androidx.lifecycle.LiveData
import com.example.core.data.CoroutinesDispatcherProvider
import com.example.core.data.dao.FurnitureDao
import com.example.core.model.CartHomeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CartRepository @Inject constructor(private val furnitureDao: FurnitureDao,
                                         private val dispatcherProvider: CoroutinesDispatcherProvider
) {

    fun getAllCartItem(): LiveData<List<CartHomeItem>> {
        return furnitureDao.fetchAllCartItem()
    }
}