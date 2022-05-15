package org.rasulov.numbercomposition.domain.usecases

import androidx.lifecycle.LiveData
import org.rasulov.numbercomposition.domain.entities.Score
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GetScore(private val repository: GameRepository) {

    operator fun invoke(): LiveData<Score> {
        return repository.getScore()
    }

}