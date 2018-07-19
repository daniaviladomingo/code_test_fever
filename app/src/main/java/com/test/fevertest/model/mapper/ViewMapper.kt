package com.test.fevertest.model.mapper

import com.test.domain.model.Crew
import com.test.domain.model.mapper.Mapper
import com.test.fevertest.model.CrewView

object ViewMapper: Mapper<Crew, CrewView>() {
    override fun map(model: Crew): CrewView = model.run { CrewView(name, area, race) }
    override fun inverseMap(model: CrewView): Crew = model.run { Crew(name, area, race) }
}