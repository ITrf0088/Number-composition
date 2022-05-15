package org.rasulov.numbercomposition.domain.usecases

import androidx.lifecycle.LiveData
import org.rasulov.numbercomposition.domain.entities.GameResult
import org.rasulov.numbercomposition.domain.entities.Score
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GetResult(private val repository: GameRepository) {

    operator fun invoke(): GameResult {
        return repository.getResult()
    }

}