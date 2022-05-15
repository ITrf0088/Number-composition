package org.rasulov.numbercomposition.domain.entities

data class GameSettings(
    val level: Level,
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val gameTimeInSeconds: Int

)
