package org.rasulov.numbercomposition.presentation.game_screen

import android.content.res.ColorStateList
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.domain.entities.Score

@BindingAdapter("to_string")
fun toString(view: TextView, obj: Any) {
    view.text = obj.toString()
}

@BindingAdapter("progress_answers")
fun setProgress(view: TextView, score: Score) {
    view.text = String.format(
        view.context.getString(R.string.progress_answers),
        score.rightAnswers,
        score.minRightAnswers
    )

    val color = ContextCompat.getColor(view.context, getColorByState(score.isEnoughAnswers))
    view.setTextColor(color)
}

@BindingAdapter("progress_percent")
fun setProgress(view: ProgressBar, score: Score) {
    val color = ContextCompat.getColor(view.context, getColorByState(score.isEnoughPercent))
    view.progress = score.percent
    view.progressTintList = ColorStateList.valueOf(color)

}

@BindingAdapter("onOptionClick")
fun optionClick(view: TextView, perform: Perform) {
    view.setOnClickListener {
        perform.perform()
    }
}


private fun getColorByState(goodState: Boolean): Int {
    return if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
}

fun interface Perform {
    fun perform()
}