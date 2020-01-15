package com.example.furnitureapp.ui.home

import com.example.core.dagger.scope.FeatureScope
import com.example.core.data.CoroutinesDispatcherProvider
import com.example.core.data.dao.FurnitureDao
import com.example.core.mock.MockHelper
import com.example.core.model.HomeItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@FeatureScope
class HomeRepository @Inject constructor(private val furnitureDao: FurnitureDao,
                                         private val mockHelper: MockHelper,
                                         private val dispatcherProvider: CoroutinesDispatcherProvider
) {

    fun getSaveAndFetchFurniture(): Flow<List<HomeItem>> {
        return flow {
            val homeNewItems = mockHelper.mockNewArrivals()
            val homePopularItems = mockHelper.mockPopularItems()

            furnitureDao.saveHomeFurnitures(homeNewItems)

            val dbData = furnitureDao.fetchAllDao()

            emit(dbData)
        }.flowOn(dispatcherProvider.io)
    }
}