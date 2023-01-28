package com.example.petcalc.screen.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.databinding.FragmentHistoryBinding
import com.example.petcalc.screen.second.adapter.HistoryAdapter
import com.example.petcalc.screen.second.model.History
import com.example.petcalc.screen.second.model.getMockSizeList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.fragment_history) {
    private var _binding: FragmentHistoryBinding? = null
    private val bindingHistoryFragment get() = _binding!!
    private val viewModel: HistoryFragmentViewModel by viewModels()
    private val historyAdapter = HistoryAdapter(this)
    private val historyList: List<History> = getMockSizeList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHistoryBinding.bind(view)

        val recyclerView: RecyclerView = bindingHistoryFragment.recyclerViewHistory
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = historyAdapter
        historyAdapter.setList(getMockSizeList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
}