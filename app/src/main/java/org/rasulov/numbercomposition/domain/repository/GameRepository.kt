package org.rasulov.numbercomposition.domain.repository

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.entities.Question

interface GameRepository {

    fun generateQuestion(maxSumValue: Int): Question

    fun getGameSettings(level: Level): GameSettings
}