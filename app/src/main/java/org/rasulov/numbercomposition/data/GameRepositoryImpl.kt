package org.rasulov.numbercomposition.data

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.entities.Question
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GameRepositoryImpl : GameRepository {

    override fun generateQuestion(maxSumValue: Int): Question {
        TODO("Not yet implemented")
    }


    override fun getGameSettings(level: Level): GameSettings {
        TODO("Not yet implemented")
    }
}