package com.test.fevertest.di.activity

import com.test.fevertest.di.application.ApplicationComponent
import com.test.fevertest.di.activity.module.ActivityModule
import com.test.fevertest.di.activity.module.ViewModelModule
import com.test.fevertest.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ViewModelModule::class)])

interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(applicationComponent: ApplicationComponent): ActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .viewModelModule(ViewModelModule())
                .build()
    }
}