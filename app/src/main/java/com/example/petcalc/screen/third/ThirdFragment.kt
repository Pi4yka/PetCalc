package com.example.petcalc.screen.third

import Diablo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentThirdBinding
import com.example.petcalc.screen.second.adapter.DogAdapter
import com.example.petcalc.screen.third.adapter.DiabloAdapter
import getMockDiabloList
import getMockDiabloStartList

class ThirdFragment : Fragment(R.layout.fragment_third) {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!
    private val diabloAdapter = DiabloAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.diabloRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.diabloRecyclerView.adapter = diabloAdapter

        diabloAdapter.setData(getMockDiabloStartList())

        binding.buttonAdd.setOnClickListener {
            diabloAdapter.addData(getMockDiabloList())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}