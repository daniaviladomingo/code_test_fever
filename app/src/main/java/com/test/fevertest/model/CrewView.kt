package com.test.fevertest.model

import android.databinding.BindingAdapter
import android.support.v4.content.ContextCompat
import android.widget.TextView
import com.test.domain.model.*
import com.test.fevertest.R

class CrewView(val name: String, val area: Area, val race: Race) {
    companion object {
        @JvmStatic @BindingAdapter("colorPosition")
        fun setColorPosition(position: TextView, area: Area) {
            when {
                area.name == AREAS.ENGINEERING.name -> position.setBackgroundColor(ContextCompat.getColor(position.context, R.color.red))
                area.name == AREAS.COMMAND.name -> position.setBackgroundColor(ContextCompat.getColor(position.context, R.color.yellow))
                area.name == AREAS.SCIENCE.name -> position.setBackgroundColor(ContextCompat.getColor(position.context, R.color.blue))
                else -> position.setBackgroundColor(ContextCompat.getColor(position.context, R.color.other))
            }
        }

        @JvmStatic @BindingAdapter("race", "area")
        fun setMultiplier(multiplier: TextView, race: Race, area: Area) {
            if (race.name == RACE.HUMAN.name && area.name == AREAS.COMMAND.name) {
                multiplier.text = "x3"
            } else if (race.name == RACE.HUMAN.name && area.name == AREAS.ENGINEERING.name) {
                multiplier.text = "x2"
            } else if (race.name == RACE.HUMAN.name && area.name == AREAS.SCIENCE.name) {
                multiplier.text = "x1"
            } else if (race.name == RACE.VULCAN.name && area.name == AREAS.COMMAND.name) {
                multiplier.text = "x1"
            } else if (race.name == RACE.VULCAN.name && area.name == AREAS.ENGINEERING.name) {
                multiplier.text = "x2"
            } else if (race.name == RACE.VULCAN.name && area.name == AREAS.SCIENCE.name) {
                multiplier.text = "x3"
            } else if (race.name == RACE.BETAZOID.name && area.name == AREAS.COMMAND.name) {
                multiplier.text = "x2"
            } else if (race.name == RACE.BETAZOID.name && area.name == AREAS.ENGINEERING.name) {
                multiplier.text = "x3"
            } else if (race.name == RACE.BETAZOID.name && area.name == AREAS.SCIENCE.name) {
                multiplier.text = "x1"
            }
        }
    }
}