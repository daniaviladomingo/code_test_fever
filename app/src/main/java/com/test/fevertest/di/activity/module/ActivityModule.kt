package com.test.fevertest.di.activity.module

import android.arch.lifecycle.ViewModelProvider
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.di.activity.PerActivity
import com.test.fevertest.ui.ViewModelFactory
import com.test.fevertest.utils.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {

    @Provides
    @PerActivity
    fun provideViewModelFactory(getCrewsSingleUseCase: GetCrewsSingleUseCase, scheduleProvider: IScheduleProvider) : ViewModelFactory =
            ViewModelFactory(getCrewsSingleUseCase, scheduleProvider)
}