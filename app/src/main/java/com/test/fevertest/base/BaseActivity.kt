package com.test.fevertest.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.test.fevertest.base.progress.IShowProgress
import com.test.fevertest.di.activity.DaggerActivity

abstract class BaseActivity : DaggerActivity(), BaseView {

    lateinit var showProgress: IShowProgress
    var toolbar: Toolbar? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getLayoutId().run {
            if (this != 0) {
                setContentView(this)
            }
        }

        initializeToolbar()
    }

    override fun onDestroy() {
        getViewModel().release()
        super.onDestroy()
    }

    private fun initializeToolbar() {}

    abstract fun getLayoutId(): Int

    abstract fun getViewModel(): BaseViewModel

    override fun showProgress(message: String) {
        showProgress.showProgress(message)
    }

    override fun dismissProgress() {
        showProgress.dismissProgress()
    }
}