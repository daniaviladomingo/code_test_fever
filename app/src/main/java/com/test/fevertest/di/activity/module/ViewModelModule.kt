package com.test.fevertest.di.activity.module

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.di.activity.PerActivity
import com.test.fevertest.ui.MainViewModel
import com.test.fevertest.utils.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    @PerActivity
    fun provideMainViewModel(getCrewsSingleUseCase: GetCrewsSingleUseCase, scheduleProvider: IScheduleProvider): MainViewModel = MainViewModel(getCrewsSingleUseCase, scheduleProvider)
}