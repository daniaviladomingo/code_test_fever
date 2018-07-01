package com.test.fevertest.ui

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.base.BasePresenter
import com.test.fevertest.utils.schedulers.IScheduleProvider
import javax.inject.Inject

class MainPresenter @Inject constructor(
                    private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                    private val scheduleProvider: IScheduleProvider): BasePresenter<MainContract.IView>(), MainContract.IPresenter {

    override fun init() {
        addDisposable(getCrewsSingleUseCase.execute(false)
                .observeOn(scheduleProvider.io())
                .subscribeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    view.showCrews(accounts)
                })
    }
}