package org.rasulov.numbercomposition.presentation.game_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentGameBinding
import org.rasulov.numbercomposition.presentation.finish_screen.FinishFragment
import java.lang.RuntimeException

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentLevelBinding == null")


    private lateinit var viewModel: GameViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[GameViewModel::class.java]
        handleReceivedQuestion()
        handleReceivedScore()
        handleTimer()
        handleFinishing()
        listenOptionsBtns()
    }


    private fun handleReceivedQuestion() {
        viewModel.question.observe(viewLifecycleOwner) {
            Log.d("itt0088", "handleReceivedQuestion: $it")
            binding.apply {
                gameSumTv.text = it.sum.toString()
                gameVisibleNumberTv.text = it.secondOperand.toString()
                gameTableLayout.apply {
                    val opt = it.options
                    zeroOptionTv.text = "${opt[0]}"
                    firstOptionTv.text = "${opt[1]}"
                    secondOptionTv.text = "${opt[2]}"
                    thirdOptionTv.text = "${opt[3]}"
                    fourthOptionTv.text = "${opt[4]}"
                    fifthOptionTv.text = "${opt[5]}"
                }
            }
        }
    }

    private fun handleReceivedScore() {
        viewModel.score.observe(viewLifecycleOwner) {
            Log.d("itt0088", "handleReceivedScore: $it")
            binding.apply {
                val template = requireContext().resources.getString(R.string.progress_answers)
                gameResultTv.text = String.format(template, it.rightAnswers, it.minRightAnswers)
                gameProgressBar.setProgress(it.percent, true)
            }
        }
    }

    private fun handleTimer() {
        viewModel.time.observe(viewLifecycleOwner) {
            binding.gameTimeTv.text = it
        }
    }

    private fun handleFinishing() {
        viewModel.finished.observe(viewLifecycleOwner) {
            if (it == true) launchFinishFragment()
        }
    }

    private fun listenOptionsBtns() {
        binding.gameTableLayout.apply {
            zeroOptionTv.setOnClickListener { answerQuestion(0) }
            firstOptionTv.setOnClickListener { answerQuestion(1) }
            secondOptionTv.setOnClickListener { answerQuestion(2) }
            thirdOptionTv.setOnClickListener { answerQuestion(3) }
            fourthOptionTv.setOnClickListener { answerQuestion(4) }
            fifthOptionTv.setOnClickListener { answerQuestion(5) }
        }
    }

    private fun answerQuestion(index: Int) {
        val options = viewModel.question.value?.options
        options?.let {
            viewModel.answerQuestion(it[index])
        }
    }

    private fun launchFinishFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FinishFragment.getInstance())
            .addToBackStack(null)
            .commit()
    }

    override fun onResume() {
        super.onResume()
        viewModel.startTimer()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.finishGameFromUser()
    }


    companion object {

        const val NAME = "GAME_FRAGMENT"

        fun getInstance(): GameFragment {
            return GameFragment()
        }
    }

}