package org.rasulov.numbercomposition.presentation.game_screen

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.rasulov.numbercomposition.data.GameRepositoryImpl
import org.rasulov.numbercomposition.domain.entities.Question
import org.rasulov.numbercomposition.domain.entities.Score
import org.rasulov.numbercomposition.domain.usecases.*

class GameViewModel : ViewModel() {

    private val repository = GameRepositoryImpl
    private var timer: CountDownTimer? = null

    private val getTimeInSeconds = GetTimeInSeconds(repository)
    private val answer = Answer(repository)
    private val finishGame = FinishGame(repository)
    private val getQuestion = GetQuestion(repository)
    private val getScore = GetScore(repository)

    private val _question = getQuestion()
    val question: LiveData<Question>
        get() = _question

    private val _score = getScore()
    val score: LiveData<Score>
        get() = _score


    private val _time = MutableLiveData<String>()
    val time: LiveData<String>
        get() = _time

    private val _finished = MutableLiveData<Boolean>()
    val finished: LiveData<Boolean>
        get() = _finished


    fun answerQuestion(index: Int) {
        question.value?.let {
            val number = it.options[index]
            answer(number)
        }
    }

    fun startTimer() {

        val timeInSeconds = (getTimeInSeconds() * 1000).toLong()

        timer = object : CountDownTimer(timeInSeconds, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val commonSeconds = millisUntilFinished / 1000
                val minutes = commonSeconds / 60
                val seconds = commonSeconds % 60

                _time.postValue(String.format("%02d:%02d", minutes, seconds))
            }

            override fun onFinish() {
                Log.d("ittt0088", "onFinish: ")
                Log.d("ittt0088", "onFinish: ")
                Log.d("ittt0088", "onFinish: ")
                Log.d("ittt0088", "onFinish: ")
                if (finishGame()) _finished.postValue(true)
            }
        }
        timer?.start()
    }


    override fun onCleared() {
        super.onCleared()
        timer?.cancel()
    }
}