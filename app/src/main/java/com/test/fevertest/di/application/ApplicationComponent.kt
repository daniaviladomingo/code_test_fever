package com.test.fevertest.di.application

import android.content.Context
import com.test.data.random.IRandomSource
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.domain.repository.IRepository
import com.test.fevertest.AppApplication
import com.test.fevertest.di.application.module.*
import com.test.fevertest.di.components.DaggerApplicationComponent
import com.test.fevertest.utils.schedulers.IScheduleProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    DataModule::class,
    RandomModule::class,
    SchedulerModule::class,
    UseCaseModule::class])

interface ApplicationComponent {

    fun provideContext(): Context

    fun provideDataSource(): IRepository

    fun provideRandomDataSource(): IRandomSource

    fun provideSchedule(): IScheduleProvider

    fun provideUseCase(): GetCrewsSingleUseCase

    companion object {
        fun init(appApplication: AppApplication): ApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(appApplication))
                .build()
    }
}