package org.rasulov.numbercomposition.domain.entities

data class GameResult(
    val isWon: Boolean,
    val rightAnswers: Int,
    val minRightAnswers: Int,
    val percent: Int,
    val minPercent: Int
)
