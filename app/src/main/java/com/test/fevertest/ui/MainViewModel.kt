package com.test.fevertest.ui

import android.databinding.ObservableArrayList
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.base.BaseViewModel
import com.test.fevertest.model.CrewView
import com.test.fevertest.model.mapper.ViewMapper
import com.test.fevertest.utils.schedulers.IScheduleProvider

class MainViewModel(private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                    private val scheduleProvider: IScheduleProvider): BaseViewModel() {

    val listCrew = ObservableArrayList<CrewView>()

    fun loadCrews() {
        disposable.add(getCrewsSingleUseCase.execute()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe { crews ->
                    listCrew.run {
                        clear()
                        addAll(ViewMapper.map(crews))
                    }
                })
    }

}