package com.test.domain.interactors

import com.test.domain.interactors.type.SingleUseCase
import com.test.domain.model.Crew
import com.test.domain.repository.IRepository

class GetCrewsSingleUseCase(private val repository: IRepository): SingleUseCase<List<Crew>> {
    override fun execute() = repository.getCrews()
}