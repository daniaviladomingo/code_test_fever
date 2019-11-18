package com.test.data.random

import com.test.domain.model.AREAS
import com.test.domain.model.Area
import com.test.domain.model.Crew
import com.test.domain.model.Race
import io.reactivex.Single

class RandomSourceImp : IRandomSource {

    private var listCrew = mutableListOf<Crew>()

    init {
        repeat((0..430).count()) {
            listCrew.add(Crew(randomName(8), Area(AREAS.random.name), Race("sasdf")))
        }
    }

    override fun getCrews(): Single<List<Crew>> {
        return Single.create<List<Crew>> {
            it.onSuccess(listCrew)
        }
    }
}