package org.rasulov.numbercomposition.presentation.level_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.rasulov.numbercomposition.data.GameRepositoryImpl
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.repository.GameRepository
import org.rasulov.numbercomposition.domain.usecases.StartGameProcess

class LevelViewModel : ViewModel() {

    private val repository: GameRepository = GameRepositoryImpl
    private val startGameProcess = StartGameProcess(repository)

    private val _started = MutableLiveData<Boolean>()
    val started: LiveData<Boolean>
        get() = _started

    fun startGame(level: Level) {
        val isStarted = startGameProcess(level)
        _started.postValue(isStarted)
    }

    fun reset() {
        _started.postValue(false)
    }


}