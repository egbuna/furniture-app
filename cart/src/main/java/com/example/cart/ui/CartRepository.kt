package com.example.cart.ui

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

    fun getAllCartItem(): Flow<List<CartHomeItem>> {
        return flow {
            val cartItems = furnitureDao.fetchAllCartItem()
            emit(cartItems)
        }.flowOn(dispatcherProvider.io)
    }
}