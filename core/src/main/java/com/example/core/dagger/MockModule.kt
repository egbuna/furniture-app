package com.example.core.dagger

import com.example.core.mock.MockHelper
import com.example.core.mock.MockHelperInterface
import dagger.Binds
import dagger.Module

@Module
abstract class MockModule {

    @Binds
    abstract fun provideMockHelper(mockHelper: MockHelper): MockHelperInterface
}