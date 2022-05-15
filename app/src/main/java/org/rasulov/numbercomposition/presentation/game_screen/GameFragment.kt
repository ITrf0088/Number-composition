package org.rasulov.numbercomposition.presentation.game_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentGameBinding
import org.rasulov.numbercomposition.presentation.finish_screen.FinishFragment
import java.lang.RuntimeException

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw RuntimeException("FragmentLevelBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun launchGameFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FinishFragment.getInstance())
            .addToBackStack(NAME)
            .commit()
    }

    companion object {

        const val NAME = "GAME_FRAGMENT"

        fun getInstance(): GameFragment {
            return GameFragment()
        }
    }

}