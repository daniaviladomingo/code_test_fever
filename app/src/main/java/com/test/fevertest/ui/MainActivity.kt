package com.test.fevertest.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.test.domain.model.Crew
import com.test.fevertest.R
import com.test.fevertest.base.BaseActivity
import com.test.fevertest.di.components.DaggerActivityComponent
import com.test.fevertest.ui.adapter.CrewListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContract.IView {

    @Inject
    lateinit var presenter: MainPresenter

    private val crewList = mutableListOf<Crew>()
    private lateinit var crewListAdapter: CrewListAdapter

    override fun getScopePresenter() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeInjector()

        crewListAdapter = CrewListAdapter(this, crewList)

        crew_recyclerview.setHasFixedSize(true)
        crew_recyclerview.adapter = crewListAdapter
        crew_recyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

    }

    private fun initializeInjector() {
        DaggerActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .activityModule(activityModule)
                .build().inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun getLayoutId() = R.layout.activity_main

    override fun showCrews(crews: List<Crew>) {
        crewList.addAll(crews)
        runOnUiThread { crewListAdapter.notifyDataSetChanged() }
    }
}
