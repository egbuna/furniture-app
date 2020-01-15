package com.example.furnitureapp.ui.detail

import android.util.Log
import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.CoroutinesDispatcherProvider
import com.example.core.data.dao.FurnitureDao
import com.example.core.model.CartHomeItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import java.sql.SQLDataException
import javax.inject.Inject

@FeatureScope
class ItemDetailRepository @Inject constructor(private val furnitureDao: FurnitureDao,
                           private val dispatcherProvider: CoroutinesDispatcherProvider
) {
    fun saveToCart(cartHomeItem: CartHomeItem) {
        CoroutineScope(dispatcherProvider.io).launch {
            try {
                furnitureDao.saveFurnitureToCart(cartHomeItem)
            } catch (e : SQLDataException) {
                print(e.message)
            }
            Log.e("SAVED_CART", "saved to cart")
        }
    }

    fun getAllCartItem(): Flow<List<CartHomeItem>> {
        return flow {
            val cartItems = furnitureDao.fetchAllCartItem()
            emit(cartItems)
        }.flowOn(dispatcherProvider.io)
    }
}