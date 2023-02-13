package com.example.petcalc.presentation.screen.history

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentHistoryBinding
import com.example.petcalc.presentation.screen.history.list.HistoryAdapter
import com.example.petcalc.presentation.screen.history.list.toItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {

    private var _binding: FragmentHistoryBinding? = null
    private val bindingHistoryFragment get() = _binding!!
    private val historyAdapter = HistoryAdapter()

    private val viewModel: HistoryFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)
        bindingHistoryFragment.recyclerViewHistory.adapter = historyAdapter
        bindingHistoryFragment.recyclerViewHistory.layoutManager = LinearLayoutManager(view.context)

        viewModel.historyItems.observe(viewLifecycleOwner) { list ->
            historyAdapter.setList(list)
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchHistoryList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }

}