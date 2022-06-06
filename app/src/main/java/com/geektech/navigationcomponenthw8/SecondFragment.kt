package com.geektech.navigationcomponenthw8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.geektech.navigationcomponenthw8.databinding.FragmentFirstBinding
import com.geektech.navigationcomponenthw8.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding:FragmentSecondBinding
    private val args: SecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(
            LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.alive.text = args.model.txt_first
        binding.name.text = args.model.txt_second
        args.model.imageView?.let { binding.imageSecond.setImageResource(it) }
    }
}

