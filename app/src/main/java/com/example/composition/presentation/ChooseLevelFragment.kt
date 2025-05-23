package com.example.composition.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.composition.R
import com.example.composition.databinding.FragmentChooseLevelBinding
import com.example.composition.domain.entity.Level

class ChooseLevelFragment : Fragment() {
    private var _binding : FragmentChooseLevelBinding? = null
    private val binding : FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding=null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonLevelEasy.setOnClickListener {
            launchGameFragment(Level.EASY)
        }
        binding.buttonLevelTest.setOnClickListener {
            launchGameFragment(Level.TEST)
        }
        binding.buttonLevelHard.setOnClickListener {
            launchGameFragment(Level.HARD)
        }
        binding.buttonLevelNormal.setOnClickListener {
            launchGameFragment(Level.NORMAL)
        }
    }

    private fun launchGameFragment(level: Level){
        val args = Bundle().apply{
            putParcelable(GameFragment.KEY_LEVEL, level)
        }
        findNavController().navigate(R.id.action_chooseLevelFragment_to_gameFragment, args)

    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

