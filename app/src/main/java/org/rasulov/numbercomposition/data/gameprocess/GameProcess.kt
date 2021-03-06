package org.rasulov.numbercomposition.data.gameprocess

import org.rasulov.numbercomposition.domain.entities.GameSettings
import org.rasulov.numbercomposition.domain.entities.Question
import org.rasulov.numbercomposition.domain.entities.Score
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

            if (mAnswer < 1) {
                mAnswer = answer
                operand = 1
            }

            mAnswer += operand
            list.add(mAnswer)
            count++
        }

        val indexOfAnswer = Random.nextInt(OPTIONS_COUNT)
        list[indexOfAnswer] = answer

        if (list.size != OPTIONS_COUNT)
            throw RuntimeException("The size of options must be $OPTIONS_COUNT , now is ${list.size}")
        return list
    }

    fun answer(answer: Int) {

        if (currentAnswer == answer) {
            countOfRightAnswers++
        }
        countOfQuestions++
    }

    fun getScore(): Score {
        val percent = ((countOfRightAnswers.toFloat() / countOfQuestions.toFloat()) * 100).toInt()

        val isEnoughAnswers = countOfRightAnswers >= gameSettings.minCountOfRightAnswers
        val isEnoughPercent = percent >= gameSettings.minPercentOfRightAnswers
        return Score(
            countOfRightAnswers,
            gameSettings.minCountOfRightAnswers,
            percent,
            isEnoughAnswers,
            isEnoughPercent
        )
    }

    companion object {
        private const val OPTIONS_COUNT = 6
    }

}