package org.rasulov.numbercomposition.domain.usecases

import androidx.lifecycle.LiveData
import org.rasulov.numbercomposition.domain.repository.GameRepository

class FinishGame(private val repository: GameRepository) {

    operator fun invoke(): Boolean {
        return repository.finishGame()
    }
}