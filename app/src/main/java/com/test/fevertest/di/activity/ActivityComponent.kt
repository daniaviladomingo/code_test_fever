package com.test.fevertest.di.activity

import com.test.fevertest.di.application.ApplicationComponent
import com.test.fevertest.di.components.DaggerActivityComponent
import com.test.fevertest.di.activity.module.ActivityModule
import com.test.fevertest.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])

interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

    companion object {
        fun init(daggerActivity: DaggerActivity, applicationComponent: ApplicationComponent): ActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(ActivityModule(daggerActivity))
                .build()
    }
}