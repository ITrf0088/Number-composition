package org.rasulov.numbercomposition.presentation.welcome_screen

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.rasulov.numbercomposition.R
import org.rasulov.numbercomposition.databinding.FragmentWelcomeBinding
import org.rasulov.numbercomposition.presentation.level_screen.LevelFragment
import java.lang.RuntimeException


class WelcomeFragment : Fragment() {


    private var _binding: FragmentWelcomeBinding? = null
    private val binding: FragmentWelcomeBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        Log.d("it0088", "onCreateView: $container")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeBtnApply.setOnClickListener {
            launchLevelFragment()
        }

    }

    private fun launchLevelFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LevelFragment.getInstance())
            .addToBackStack(null)
            .commit()
    }
}