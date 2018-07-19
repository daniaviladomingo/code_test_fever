package com.test.domain.interactors

import com.test.domain.interactors.type.SingleUseCaseWithParameter
import com.test.domain.model.Crew
import com.test.domain.repository.IRepository

class GetCrewsSingleUseCase(private val repository: IRepository): SingleUseCaseWithParameter<Boolean, List<Crew>> {
    override fun execute(parameter: Boolean) = repository.getCrews()
}