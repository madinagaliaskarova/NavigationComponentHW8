package com.geektech.navigationcomponenthw8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.geektech.navigationcomponenthw8.databinding.FragmentFirstBinding

class FirstFragment : Fragment(), OnClickItem {
    private lateinit var binding: FragmentFirstBinding
    private val data = mutableListOf<Model>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(
            LayoutInflater.from(requireContext()), container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = Adapter(data as ArrayList<Model>, this)
        binding.recycler.adapter = adapter
    }

    private fun loadData() {
        data.apply {
            data.add(Model(R.drawable.image1, "Alive", "Rick Sanchez"))
            data.add(Model(R.drawable.image2, "Alive", "Morty Smith"))
            data.add(Model(R.drawable.image3, "Dead", "Albert Einstein"))
            data.add(Model(R.drawable.image4, "Alive", "Jerry Smith"))
        }
    }

    override fun onClick(model: Model) {
        findNavController().navigate(
            FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                model
            )
        )
    }
}