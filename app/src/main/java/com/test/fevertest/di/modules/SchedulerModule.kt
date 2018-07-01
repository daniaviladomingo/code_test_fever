package com.test.fevertest.di.modules

import com.test.fevertest.utils.schedulers.IScheduleProvider
import com.test.fevertest.utils.schedulers.ScheduleProviderImp
import dagger.Module
import dagger.Provides

@Module
class SchedulerModule {
    @Provides
    fun provideScheduleProvider(): IScheduleProvider = ScheduleProviderImp()
}