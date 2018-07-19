package com.test.fevertest.base

import android.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel: BaseObservable() {
    protected val disposable = CompositeDisposable()

    fun release() {
        if (!disposable.isDisposed) {
            disposable.dispose()
        }
    }
}