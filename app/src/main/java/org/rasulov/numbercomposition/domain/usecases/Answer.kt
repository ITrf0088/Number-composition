package org.rasulov.numbercomposition.domain.usecases

import org.rasulov.numbercomposition.domain.repository.GameRepository

class Answer(val repository: GameRepository) {

    operator fun invoke(option: Int) {
        repository.answer(option)
    }
}