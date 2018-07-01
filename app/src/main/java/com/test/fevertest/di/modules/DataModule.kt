package com.test.fevertest.di.modules

import com.test.data.RepositoryImp
import com.test.data.random.IRandomSource
import com.test.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(randomDataSource: IRandomSource) : IRepository = RepositoryImp(randomDataSource)
}