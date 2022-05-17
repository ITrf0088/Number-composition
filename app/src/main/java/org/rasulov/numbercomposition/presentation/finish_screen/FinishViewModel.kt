package org.rasulov.numbercomposition.presentation.finish_screen

import androidx.lifecycle.ViewModel
import org.rasulov.numbercomposition.data.GameRepositoryImpl
import org.rasulov.numbercomposition.domain.usecases.GetResult

class FinishViewModel : ViewModel() {
    private val repository = GameRepositoryImpl
    val result = GetResult(repository).invoke()
}