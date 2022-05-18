package org.rasulov.numbercomposition.presentation.level_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentLevelBinding
import org.rasulov.numbercomposition.domain.entities.Level
import org.rasulov.numbercomposition.domain.entities.Level.*
import org.rasulov.numbercomposition.presentation.game_screen.GameFragment
import java.lang.RuntimeException

class LevelFragment : Fragment() {

    private var _binding: FragmentLevelBinding? = null
    private val binding: FragmentLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentLevelBinding == null")

    private lateinit var viewModel: LevelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[LevelViewModel::class.java]
        viewModel.started.observe(viewLifecycleOwner) {
            Log.d("itt0088", "startedGameProcess: $it")
            if (it) launchGameFragment()
        }
        binding.levelBtnEasy.setOnClickListener { viewModel.startGame(EASY) }
        binding.levelBtnNormal.setOnClickListener { viewModel.startGame(NORMAL) }
        binding.levelBtnHard.setOnClickListener { viewModel.startGame(HARD) }
        binding.levelBtnTest.setOnClickListener { viewModel.startGame(TEST) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        viewModel.reset()
    }

    private fun launchGameFragment() {
        findNavController().navigate(R.id.action_levelFragment_to_gameFragment)

    }

}