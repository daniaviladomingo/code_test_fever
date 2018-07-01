package com.test.fevertest.di.modules

import com.test.fevertest.base.BaseActivity
import dagger.Module

@Module
class ActivityModule(private val baseActivity: BaseActivity) {

//    @Provides
//    @PerActivity
//    internal fun provideActivity(): BaseActivity = this.baseActivity
}