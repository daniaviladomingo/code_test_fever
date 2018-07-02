package com.test.fevertest

import android.app.Application
import com.test.fevertest.di.application.ApplicationComponent
import com.test.fevertest.di.createApplicationComponent

class AppApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = createApplicationComponent(this)
    }
}