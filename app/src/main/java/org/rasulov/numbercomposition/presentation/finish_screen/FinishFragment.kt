package org.rasulov.numbercomposition.presentation.finish_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentFinishBinding
import org.rasulov.numbercomposition.presentation.game_screen.GameFragment
import org.rasulov.numbercomposition.presentation.game_screen.GameViewModel
import java.lang.RuntimeException

class FinishFragment : Fragment() {

    private var _binding: FragmentFinishBinding? = null
    private val binding: FragmentFinishBinding
        get() = _binding ?: throw RuntimeException("FragmentLevelBinding == null")

    private lateinit var viewModel: FinishViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFinishBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FinishViewModel::class.java]
        observeFinishResult()
        binding.buttonRetry.setOnClickListener { retry() }


    }

    private fun observeFinishResult() {
        val result = viewModel.result
        if (result.isWon) {
            binding.finishEmojiImg.setImageResource(R.drawable.ic_smile)
        } else {
            binding.finishEmojiImg.setImageResource(R.drawable.ic_sad)
        }
        binding.finishRequiredCorrectAnswersTv.text =
            String.format(getString(R.string.required_score), result.minRightAnswers)
        binding.finishCorrectAnswersTv.text =
            String.format(getString(R.string.score_answers), result.rightAnswers)
        binding.finishRequiredPercentTv.text =
            String.format(getString(R.string.required_percentage), result.minPercent)
        binding.finishPercentTv.text =
            String.format(getString(R.string.score_percentage), result.percent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun retry() {
        findNavController().popBackStack()
    }


}