package org.rasulov.numbercomposition.data.gameprocess

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Question
import org.rasulov.numbercomposition.domain.entities.Score
import java.lang.RuntimeException
import kotlin.random.Random

class GameProcess(val gameSettings: GameSettings) {


    var countOfRightAnswers: Int = 0

    var countOfQuestions: Int = 0

    private var currentAnswer: Int = 0

    fun generateQuestion(): Question {
        val sum = Random.nextInt(2, gameSettings.maxSumValue + 1)
        val secondOperand = Random.nextInt(1, sum)
        val firstOperandAnswer = sum - secondOperand
        currentAnswer = firstOperandAnswer

        return Question(
            sum,
            secondOperand,
            generateOptions(firstOperandAnswer)
        )


    }

    private fun generateOptions(answer: Int): List<Int> {

        val list: MutableList<Int> = mutableListOf()

        var mAnswer = answer
        var operand = -1
        var count = 0

        while (count < OPTIONS_COUNT) {
            mAnswer += operand

            if (mAnswer > 0) {
                list.add(mAnswer)
            } else {
                mAnswer = answer
                operand = 1
            }
            count++
        }

        val indexOfAnswer = Random.nextInt(OPTIONS_COUNT)
        list[indexOfAnswer] = answer

        if (list.size != OPTIONS_COUNT)
            throw RuntimeException("The size of options must be $OPTIONS_COUNT")

        return list
    }

    fun answer(answer: Int) {
        if (currentAnswer == answer) {
            countOfRightAnswers++
        }
        countOfQuestions++
    }

    fun getScore(): Score {
        return Score(
            countOfRightAnswers,
            gameSettings.minCountOfRightAnswers,
            ((countOfRightAnswers / countOfQuestions) / 100)
        )
    }

    companion object {
        private const val OPTIONS_COUNT = 6
    }

}