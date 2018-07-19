package com.test.fevertest.ui

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.test.fevertest.model.CrewView
import com.test.fevertest.ui.adapter.CrewListAdapter

@BindingAdapter("app:items")
fun setItems(recyclerView: RecyclerView, listCrew: List<CrewView>) {
    (recyclerView.adapter as CrewListAdapter).replaceData(listCrew)
}