package com.example.furnitureapp.ui.home

import com.example.core.dagger.scope.FeatureScope
import com.example.furnitureapp.data.local.dao.FurnitureDao
import com.example.furnitureapp.data.mock.MockHelper
import com.example.furnitureapp.data.model.HomeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@FeatureScope
class HomeRepository @Inject constructor(private val furnitureDao: FurnitureDao,
                                         private val mockHelper: MockHelper) {

    fun getSaveAndFetchFurniture(): Flow<List<HomeItem>> {
        return flow {
            val homeNewItems = mockHelper.mockNewArrivals()
            val homePopularItems = mockHelper.mockPopularItems()

            furnitureDao.saveHomeFurniture(homeNewItems)

            val dbData = furnitureDao.fetchAllDao()

            emit(dbData)
        }.flowOn(Dispatchers.IO)
    }
}