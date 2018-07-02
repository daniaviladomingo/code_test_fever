package com.test.fevertest.di.application.module

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.domain.repository.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetCrewSingleUseCase(repository: IRepository) = GetCrewsSingleUseCase(repository)
}