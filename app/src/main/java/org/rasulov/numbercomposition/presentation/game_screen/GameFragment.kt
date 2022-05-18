package org.rasulov.numbercomposition.presentation.game_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentGameBinding

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

        if (savedInstanceState == null)
            viewModel.startTimer()


        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.gameTableLayout.viewModel = viewModel
        binding.gameTableLayout.lifecycleOwner = viewLifecycleOwner

        handleFinishing()
    }

    private fun handleFinishing() {
        viewModel.finished.observe(viewLifecycleOwner) {
            if (it == true) launchFinishFragment()
        }
    }


    private fun launchFinishFragment() {
        findNavController().navigate(R.id.action_gameFragment_to_finishFragment)

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}