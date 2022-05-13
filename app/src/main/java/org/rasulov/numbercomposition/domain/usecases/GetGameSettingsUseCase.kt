package org.rasulov.numbercomposition.domain.usecases

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.repository.GameRepository

class GetGameSettingsUseCase(private val repository: GameRepository) {

    operator fun invoke(level: Level):GameSettings {
        return repository.getGameSettings(level)
    }
}