package org.rasulov.numbercomposition.domain.repository

import androidx.lifecycle.LiveData
import org.rasulov.numbercomposition.domain.entities.*

interface GameRepository {

    fun startGameProcess(level: Level): Boolean

    fun getTimeInSeconds(): Int

    fun getScore(): LiveData<Score>

    fun getQuestions(): LiveData<Question>

    fun answer(option: Int)

    fun getResult(): GameResult

    fun finishGame(): Boolean


}