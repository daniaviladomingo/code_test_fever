package com.test.fevertest.ui.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.domain.model.AREAS
import com.test.domain.model.Crew
import com.test.domain.model.RACE
import com.test.fevertest.R
import kotlinx.android.synthetic.main.item_crew.view.*

class CrewListAdapter(private var context: Context, private var crewList: List<Crew>): RecyclerView.Adapter<CrewListAdapter.CrewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CrewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_crew, parent, false))

    override fun getItemCount() = crewList.size

    override fun onBindViewHolder(holder: CrewHolder, position: Int) = holder.bin(crewList[position])

    inner class CrewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bin(crew: Crew){
            crew.run {
                when {
                    crew.area.name == AREAS.ENGINEERING.name -> itemView.position.setBackgroundColor(ContextCompat.getColor(context, R.color.red))
                    crew.area.name == AREAS.COMMAND.name -> itemView.position.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow))
                    crew.area.name == AREAS.SCIENCE.name -> itemView.position.setBackgroundColor(ContextCompat.getColor(context, R.color.blue))
                    else -> itemView.position.setBackgroundColor(ContextCompat.getColor(context, R.color.other))
                }
                itemView.crew_name.text = name
                itemView.crew_race.text = race.name
                setMultiplier(this, itemView)

            }
        }
    }

    private fun setMultiplier(crew: Crew, itemView: View) {
        if (crew.race.name == RACE.HUMAN.name && crew.area.name == AREAS.COMMAND.name) {
            itemView.multiplier.text = "x3"
        } else if (crew.race.name == RACE.HUMAN.name && crew.area.name == AREAS.ENGINEERING.name) {
            itemView.multiplier.text = "x2"
        } else if (crew.race.name == RACE.HUMAN.name && crew.area.name == AREAS.SCIENCE.name) {
            itemView.multiplier.text = "x1"
        } else if (crew.race.name == RACE.VULCAN.name && crew.area.name == AREAS.COMMAND.name) {
            itemView.multiplier.text = "x1"
        } else if (crew.race.name == RACE.VULCAN.name && crew.area.name == AREAS.ENGINEERING.name) {
            itemView.multiplier.text = "x2"
        } else if (crew.race.name == RACE.VULCAN.name && crew.area.name == AREAS.SCIENCE.name) {
            itemView.multiplier.text = "x3"
        } else if (crew.race.name == RACE.BETAZOID.name && crew.area.name == AREAS.COMMAND.name) {
            itemView.multiplier.text = "x2"
        } else if (crew.race.name == RACE.BETAZOID.name && crew.area.name == AREAS.ENGINEERING.name) {
            itemView.multiplier.text = "x3"
        } else if (crew.race.name == RACE.BETAZOID.name && crew.area.name == AREAS.SCIENCE.name) {
            itemView.multiplier.text = "x1"
        }
    }
}