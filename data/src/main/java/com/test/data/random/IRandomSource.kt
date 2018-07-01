package com.test.data.random

import com.test.domain.model.Crew
import io.reactivex.Single

interface IRandomSource {
    fun getCrews(): Single<List<Crew>>
}