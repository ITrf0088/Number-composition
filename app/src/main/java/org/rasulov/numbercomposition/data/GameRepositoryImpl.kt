package org.rasulov.numbercomposition.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import org.rasulov.numbercomposition.data.gameprocess.GameProcess
import org.rasulov.numbercomposition.data.gameprocess.GameProcessFactory
import org.rasulov.numbercomposition.domain.entities.*
import org.rasulov.numbercomposition.domain.repository.GameRepository
import java.lang.RuntimeException

object GameRepositoryImpl : GameRepository {

    private val score: MutableLiveData<Score> = MutableLiveData()
    private val questions: MutableLiveData<Question> = MutableLiveData()
    private lateinit var gameProcess: GameProcess


    override fun startGameProcess(level: Level): Boolean {
        gameProcess = GameProcessFactory.generate(level)
        return true
    }

    override fun getTimeInSeconds(): Int {
        return gameProcess.gameSettings.gameTimeInSeconds
    }

    override fun getScore(): LiveData<Score> {
        return score
    }

    override fun getQuestions(): LiveData<Question> {
        return questions
    }

    override fun answer(option: Int) {
        gameProcess.answer(option)
        score.postValue(gameProcess.getScore())
        questions.postValue(gameProcess.generateQuestion())
    }

    override fun getResult(): GameResult {

        val mScore = score.value

        if (mScore != null) {
            val settings = gameProcess.gameSettings

            val rightAnswers = mScore.rightAnswers
            val minRightAnswers = settings.minCountOfRightAnswers
            val percent = mScore.percent
            val minPercent = settings.minPercentOfRightAnswers

            val isWon = rightAnswers >= minRightAnswers && percent >= minPercent
            return GameResult(isWon, rightAnswers, minRightAnswers, percent, minPercent)
        }

        throw RuntimeException("In the Game process score needs to be filled")
    }


}