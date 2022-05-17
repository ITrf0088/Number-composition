package org.rasulov.numbercomposition.data.gameprocess

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.entities.Level.*

class GameProcessFactory {
    companion object {
        fun generate(level: Level): GameProcess {
            val settings = when (level) {
                EASY -> GameSettings(level, 10, 20, 50, 60)
                NORMAL -> GameSettings(level, 30, 25, 70, 50)
                HARD -> GameSettings(level, 35, 30, 80, 50)
                TEST -> GameSettings(level, 20, 5, 10, 5)
            }

            return GameProcess(settings)
        }
    }
}
