package org.rasulov.numbercomposition.domain.entities

data class GameSettings(
    val maxSumValue: Int,
    val minCountOfRightAnswers: Int,
    val minPercentOfRightAnswers: Int,
    val GameTimeInSeconds: Int
)
