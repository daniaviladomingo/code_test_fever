package com.test.fevertest.ui

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.test.domain.model.Crew
import com.test.fevertest.R
import com.test.fevertest.base.BaseActivity
import com.test.fevertest.di.activity.ActivityComponent
import com.test.fevertest.ui.adapter.CrewListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.IView {

    @Inject
    lateinit var presenter: MainContract.IPresenter

    private val crewList = mutableListOf<Crew>()
    private lateinit var crewListAdapter: CrewListAdapter

    override fun getScopePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        crewListAdapter = CrewListAdapter(this, crewList)

        crew_recyclerview.setHasFixedSize(true)
        crew_recyclerview.adapter = crewListAdapter
        crew_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun showCrews(crews: List<Crew>) {
        crewList.addAll(crews)
        runOnUiThread { crewListAdapter.notifyDataSetChanged() }
    }

    override fun inject(activityComponent: ActivityComponent) {
        activityComponent.inject(this)
    }
}
