package com.test.fevertest

import android.app.Application
import com.test.fevertest.di.components.ApplicationComponent
import com.test.fevertest.di.components.DaggerApplicationComponent
import com.test.fevertest.di.modules.ApplicationModule

class AppApplication: Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeInjector()
    }

    private fun initializeInjector() {
        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}