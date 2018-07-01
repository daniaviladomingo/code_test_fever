package com.test.fevertest.base.progress

import android.app.ProgressDialog

class ShowProgressImp(var progressDialog: ProgressDialog): IShowProgress {

    override fun showProgress(message: String) {
        progressDialog.run {
            setMessage(message)
            show()
        }
    }

    override fun dismissProgress() {
        progressDialog.dismiss()
    }
}