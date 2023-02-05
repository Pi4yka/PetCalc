package com.example.petcalc.presentation.screen.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentHistoryBinding
import com.example.petcalc.presentation.screen.history.list.HistoryAdapter
import com.example.petcalc.presentation.screen.history.list.getMockHistoryItemList
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var _binding: FragmentHistoryBinding? = null
    private val bindingHistoryFragment get() = _binding!!

    private val viewModel: HistoryFragmentViewModel by viewModels()
    private val historyAdapter = HistoryAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        val recyclerView: RecyclerView = bindingHistoryFragment.recyclerViewHistory
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = historyAdapter
        historyAdapter.setList(getMockHistoryItemList())

    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}