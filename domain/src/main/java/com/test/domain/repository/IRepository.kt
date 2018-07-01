package com.test.domain.repository

import com.test.domain.model.Crew
import io.reactivex.Single

interface IRepository {
    fun getCrews(): Single<List<Crew>>
}