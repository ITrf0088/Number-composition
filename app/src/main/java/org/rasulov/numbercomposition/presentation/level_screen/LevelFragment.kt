package org.rasulov.numbercomposition.presentation.level_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentLevelBinding
import org.rasulov.numbercomposition.presentation.game_screen.GameFragment
import java.lang.RuntimeException

class LevelFragment : Fragment() {

    private var _binding: FragmentLevelBinding? = null
    private val binding: FragmentLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentLevelBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.levelBtnEasy.setOnClickListener { launchGameFragment() }
        binding.levelBtnNormal.setOnClickListener { launchGameFragment() }
        binding.levelBtnHard.setOnClickListener { launchGameFragment() }
        binding.levelBtnTest.setOnClickListener { launchGameFragment() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, GameFragment.getInstance())
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun getInstance(): LevelFragment {
            return LevelFragment()
        }
    }
}