package org.rasulov.numbercomposition.domain.entities

data class Question(
    val sum: Int,
    val secondOperand: Int,
    val options: List<Int>
)