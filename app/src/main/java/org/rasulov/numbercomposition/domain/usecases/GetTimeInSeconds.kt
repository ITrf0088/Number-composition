package org.rasulov.numbercomposition.domain.usecases

import org.rasulov.numbercomposition.domain.entities.GameResult
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GetTimeInSeconds(private val repository: GameRepository) {

    operator fun invoke(): Int {
       return repository.getTimeInSeconds()
    }

}