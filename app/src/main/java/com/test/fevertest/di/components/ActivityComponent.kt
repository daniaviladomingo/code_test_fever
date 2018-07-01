package com.test.fevertest.di.components

import com.test.fevertest.di.modules.ActivityModule
import com.test.fevertest.di.qualifiers.PerActivity
import com.test.fevertest.ui.MainActivity
import dagger.Component

@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}