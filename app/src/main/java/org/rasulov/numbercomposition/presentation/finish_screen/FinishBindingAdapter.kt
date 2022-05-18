package org.rasulov.numbercomposition.presentation.finish_screen

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.rasulov.numbercomposition.R


@BindingAdapter("setEmoji")
fun bindEmoji(img: ImageView, isWon: Boolean) {
    if (isWon) {
        img.setImageResource(R.drawable.ic_smile)
    } else {
        img.setImageResource(R.drawable.ic_sad)
    }
}


@BindingAdapter("requiredRightAnswers")
fun bindRequiredRightAnswers(tv: TextView, count: Int) {
    tv.text = String.format(tv.context.getString(R.string.required_score), count)
}


@BindingAdapter("rightAnswers")
fun bindRightAnswers(tv: TextView, count: Int) {
    tv.text = String.format(tv.context.getString(R.string.score_answers), count)
}


@BindingAdapter("requiredPercent")
fun bindRequiredPercent(tv: TextView, percent: Int) {
    tv.text = String.format(tv.context.getString(R.string.required_percentage), percent)
}

@BindingAdapter("percent")
fun bindPercent(tv: TextView, percent: Int) {
    tv.text = String.format(tv.context.getString(R.string.score_percentage), percent)
}