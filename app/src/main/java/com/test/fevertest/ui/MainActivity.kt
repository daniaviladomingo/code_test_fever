package com.test.fevertest.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.test.fevertest.R
import com.test.fevertest.base.BaseActivity
import com.test.fevertest.databinding.ActivityMainBinding
import com.test.fevertest.di.activity.ActivityComponent
import com.test.fevertest.ui.adapter.CrewListAdapter
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).run {
            crewRecyclerview.run {
                setHasFixedSize(true)
                adapter = CrewListAdapter()
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            }

            viewModel = mainViewModel
        }

        mainViewModel.loadCrews()
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun getViewModel() = mainViewModel

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
