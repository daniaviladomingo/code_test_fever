package com.test.fevertest.ui

import com.test.domain.interactors.GetCrewsSingleUseCase
import com.test.fevertest.base.BasePresenter
import com.test.fevertest.utils.schedulers.IScheduleProvider

class MainPresenter(private val getCrewsSingleUseCase: GetCrewsSingleUseCase,
                    private val scheduleProvider: IScheduleProvider,
                    view: MainContract.IView): BasePresenter<MainContract.IView>(view), MainContract.IPresenter {

    override fun init() {
        addDisposable(getCrewsSingleUseCase.execute()
                .observeOn(scheduleProvider.io())
                .subscribeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    view.showCrews(accounts)
                })
    }
}