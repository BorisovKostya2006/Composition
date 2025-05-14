package com.example.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.composition.R
import com.example.composition.databinding.FragmentGameFinishBinding
import java.lang.RuntimeException


class FragmentGameFinish : Fragment() {

    var _binding : FragmentGameFinishBinding? = null
    val binding : FragmentGameFinishBinding
        get() = _binding ?: throw RuntimeException("FragmentGameFinishBinding = null")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGameFinishBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRetry.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, ChooseLevelFragment())
                .commit()
           
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}