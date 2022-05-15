package org.rasulov.numbercomposition.data.gameprocess

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.entities.Level.*

class GameProcessFactory {
    companion object {
        fun generate(level: Level): GameProcess {
            val settings = when (level) {
                EASY -> GameSettings(level, 10, 20, 50, 60)
                NORMAL -> GameSettings(level, 20, 25, 70, 50)
                HARD -> GameSettings(level, 30, 30, 80, 50)
                TEST -> GameSettings(level, 20, 5, 10, 10)
            }

            return GameProcess(settings)
        }
    }
}
