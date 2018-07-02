package com.test.fevertest.di.application.module

import com.test.data.random.IRandomSource
import com.test.data.random.RandomSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RandomModule {
    @Provides
    @Singleton
    fun provideRandomDataSource(): IRandomSource = RandomSourceImp()
}