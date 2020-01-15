package com.example.cart.ui

import androidx.lifecycle.LiveData
import com.example.core.data.CoroutinesDispatcherProvider
import com.example.core.data.dao.FurnitureDao
import com.example.core.model.CartHomeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.sql.SQLDataException
import javax.inject.Inject

class CartRepository @Inject constructor(private val furnitureDao: FurnitureDao,
                                         private val dispatcherProvider: CoroutinesDispatcherProvider
) {

    fun getAllCartItem(): LiveData<List<CartHomeItem>> {
        return furnitureDao.fetchAllCartItem()
    }

    fun deleteCartItem(itemName: String) {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                furnitureDao.deleteCartItem(itemName)
            } catch (e : SQLDataException) {
                print(e.message)
            }
        }
    }
}