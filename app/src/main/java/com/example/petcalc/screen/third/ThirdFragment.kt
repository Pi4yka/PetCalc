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

        binding.diabloRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.diabloRecyclerView.adapter = diabloAdapter

        val necromancer = Diablo(
            1, "Necromancer", "Trag'Oul Death Nova",
            R.drawable.necromancer
        )
        val monk = Diablo(2, "Monk", "LoD Wave Of Light", R.drawable.monk)

        diabloAdapter.setData(listOf(necromancer, monk))

        binding.buttonAdd.setOnClickListener {
            val demonHunter = Diablo(
                3, "Demon Hunter", "Shadow Impale",
                R.drawable.demonhunter
            )
            val barbarian = Diablo(4, "Barbarian", "LoD HotA", R.drawable.monk)
            val crusader =
                Diablo(5, "Crusader", "LoN Bombardment", R.drawable.monk)
            val witchDoctor =
                Diablo(6, "Witch Doctor", "Zunimassa Poison Dart", R.drawable.monk)
            val wizard =
                Diablo(7, "Wizard", "LoD 'Bazooka' Meteor", R.drawable.monk)
            diabloAdapter.setData(
                listOf(
                    necromancer, monk, demonHunter , barbarian, crusader,
                    witchDoctor, wizard
                )
            )
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}