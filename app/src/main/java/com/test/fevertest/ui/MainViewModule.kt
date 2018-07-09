package com.test.fevertest.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.domain.model.Crew
import com.test.fevertest.utils.schedulers.IScheduleProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModule(private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                     private val scheduleProvider: IScheduleProvider): ViewModel() {

    val mutableLiveData = MutableLiveData<List<Crew>>()

    private val disposable = CompositeDisposable()

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    fun loadCrews() {
        disposable.add(getCrewsSingleUseCase.execute(false)
                .observeOn(scheduleProvider.io())
                .subscribeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    mutableLiveData.value = accounts
                })
    }
}