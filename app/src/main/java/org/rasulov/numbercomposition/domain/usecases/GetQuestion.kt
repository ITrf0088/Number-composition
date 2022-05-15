package org.rasulov.numbercomposition.domain.usecases

import androidx.lifecycle.LiveData
import org.rasulov.numbercomposition.domain.entities.Question
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GetQuestion(private val repository: GameRepository) {

    operator fun invoke(): LiveData<Question> {
        return repository.getQuestions()
    }


}