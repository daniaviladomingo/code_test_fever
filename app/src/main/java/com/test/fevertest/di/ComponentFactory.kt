package com.test.fevertest.di

import com.test.fevertest.AppApplication
import com.test.fevertest.di.activity.ActivityComponent
import com.test.fevertest.di.activity.DaggerActivity
import com.test.fevertest.di.application.ApplicationComponent

fun createApplicationComponent(appApplication: AppApplication): ApplicationComponent = ApplicationComponent.init(appApplication)

fun createActivityComponent(appApplication: AppApplication): ActivityComponent = ActivityComponent.init(appApplication.applicationComponent)
