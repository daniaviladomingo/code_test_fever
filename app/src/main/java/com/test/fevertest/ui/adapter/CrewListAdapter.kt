package com.test.fevertest.ui.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.test.fevertest.R
import com.test.fevertest.databinding.ItemCrewBinding
import com.test.fevertest.model.CrewView

class CrewListAdapter: RecyclerView.Adapter<CrewListAdapter.CrewHolder>() {

    private var crewList: List<CrewView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewHolder =
            CrewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_crew, parent, false))

    override fun getItemCount() = crewList.size

    override fun onBindViewHolder(holder: CrewHolder, position: Int) = holder.bind(crewList[position])

    fun replaceData(crewList: List<CrewView>) {
        this.crewList = crewList
        notifyDataSetChanged()
    }

    inner class CrewHolder(private val crewBinding: ItemCrewBinding) : RecyclerView.ViewHolder(crewBinding.root) {
        fun bind(crew: CrewView){
            crewBinding.crew = crew
        }
    }


}