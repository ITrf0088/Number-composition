package org.rasulov.numbercomposition.presentation.finish_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import org.rasulov.numbercomposition.databinding.FragmentFinishBinding
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
        bindResult()
        binding.buttonRetry.setOnClickListener { retry() }


    }

    private fun bindResult() {
        binding.gameResult = viewModel.result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun retry() {
        findNavController().popBackStack()
    }


}