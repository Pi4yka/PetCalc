package com.example.petcalc.screen.second

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentHistoryBinding
import com.example.petcalc.databinding.FragmentHowtoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HowToFragment : Fragment(R.layout.fragment_howto) {
    private var _binding: FragmentHowtoBinding? = null
    private val bindingHowToFragment get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHowtoBinding.bind(view)
        Log.d("TTT","CREATED")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}