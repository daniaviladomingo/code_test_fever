package com.test.fevertest.di.activity.module

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.di.activity.DaggerActivity
import com.test.fevertest.di.activity.PerActivity
import com.test.fevertest.ui.MainActivity
import com.test.fevertest.ui.MainContract
import com.test.fevertest.ui.MainPresenter
import com.test.fevertest.utils.schedulers.IScheduleProvider
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val daggerActivity: DaggerActivity) {

    @Provides
    @PerActivity
    fun provideMainPresenter(getCrewsSingleUseCase: GetCrewsSingleUseCase, scheduleProvider: IScheduleProvider) : MainContract.IPresenter =
        MainPresenter(getCrewsSingleUseCase, scheduleProvider, daggerActivity as MainActivity)
}