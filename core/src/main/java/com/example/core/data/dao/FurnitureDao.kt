package com.example.core.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.core.dagger.scope.FeatureScope
import com.example.core.model.CartHomeItem
import com.example.core.model.HomeItem
import kotlinx.coroutines.flow.Flow

@Dao
@FeatureScope
interface FurnitureDao {

    @Query("select * from homeitem")
    fun fetchAllDao(): List<HomeItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveHomeFurnitures(furnitures: ArrayList<HomeItem>): List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFurniture(homeItem: HomeItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFurnitureToCart(cartHomeItem: CartHomeItem)

    @Query("select * from cart")
    fun fetchAllCartItem(): LiveData<List<CartHomeItem>>

    @Query("delete from cart where name = :furnitureName")
    suspend fun deleteCartItem(furnitureName: String)
}