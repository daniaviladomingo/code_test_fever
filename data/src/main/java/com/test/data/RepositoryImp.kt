package com.test.data

import com.test.data.random.IRandomSource
import com.test.domain.model.Crew
import com.test.domain.repository.IRepository
import io.reactivex.Single

class RepositoryImp(private val randomSource: IRandomSource): IRepository {
    override fun getCrews(): Single<List<Crew>> = randomSource.getCrews()
}