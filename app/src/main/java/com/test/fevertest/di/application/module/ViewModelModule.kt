package com.test.fevertest.di.application.module

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.ui.ViewModelFactory
import com.test.fevertest.utils.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(getCrewsSingleUseCase: GetCrewsSingleUseCase, scheduleProvider: IScheduleProvider) : ViewModelFactory =
            ViewModelFactory(getCrewsSingleUseCase, scheduleProvider)
}