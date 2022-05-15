package org.rasulov.numbercomposition.domain.usecases

import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.repository.GameRepository

class StartGameProcess(private val repository: GameRepository) {

    operator fun invoke(level: Level): Boolean {
        return repository.startGameProcess(level)
    }
}