package com.test.fevertest.ui

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.arch.lifecycle.ViewModelProviders
import com.test.domain.model.Crew
import com.test.fevertest.R
import com.test.fevertest.base.BaseActivity
import com.test.fevertest.di.activity.ActivityComponent
import com.test.fevertest.ui.adapter.CrewListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var mainViewModule: MainViewModule

    private val crewList = mutableListOf<Crew>()
    private lateinit var crewListAdapter: CrewListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crewListAdapter = CrewListAdapter(this, crewList)

        crew_recyclerview.setHasFixedSize(true)
        crew_recyclerview.adapter = crewListAdapter
        crew_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mainViewModule = ViewModelProviders.of(this, viewModelFactory).get(MainViewModule::class.java)

        mainViewModule.listCrew.observe(this, Observer {
            crewList.addAll(it!!)
            crewListAdapter.notifyDataSetChanged()
        })

        mainViewModule.loadCrews()
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
