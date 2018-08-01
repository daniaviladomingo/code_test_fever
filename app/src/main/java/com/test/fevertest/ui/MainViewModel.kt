package com.test.fevertest.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.domain.model.Crew
import com.test.fevertest.utils.schedulers.IScheduleProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                    private val scheduleProvider: IScheduleProvider) : ViewModel() {

    private val disposable = CompositeDisposable()

    var listCrew: MutableLiveData<List<Crew>>? = null
        get() {
            field = field ?: MutableLiveData()
            loadCrews()
            return field
        }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    private fun loadCrews() {
        disposable.add(getCrewsSingleUseCase.execute()
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe { crews ->
                    listCrew?.value = crews
                })
    }
}