package com.test.fevertest.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.utils.schedulers.IScheduleProvider

class ViewModelFactory(private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                       private val scheduleProvider: IScheduleProvider) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>) =
            with(modelClass) {
                when {
                    isAssignableFrom(MainViewModule::class.java) -> MainViewModule(getCrewsSingleUseCase, scheduleProvider)
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")

                }
            } as T
}