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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("it0088", "onCreate: welcome")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        Log.d("it0088", "onCreateView: welcome")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeBtnApply.setOnClickListener {
            launchLevelFragment()
        }
        Log.d("it0088", "onViewCreated: welcome")

    }

    private fun launchLevelFragment() {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LevelFragment.getInstance())
            .commit()

    }

    override fun onStart() {
        super.onStart()
        Log.d("it0088", "onStart: welcome")
    }

    override fun onResume() {
        super.onResume()
        Log.d("it0088", "onResume: welcome")
    }

    override fun onPause() {
        super.onPause()
        Log.d("it0088", "onPause: welcome ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("it0088", "onStop: welcome")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("it0088", "onDestroy: welcome ")
    }
}