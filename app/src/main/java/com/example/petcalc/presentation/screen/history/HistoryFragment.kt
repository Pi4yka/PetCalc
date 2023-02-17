package com.example.petcalc.presentation.screen.history

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.databinding.FragmentHistoryBinding
import com.example.petcalc.presentation.screen.history.list.HistoryAdapter
import com.example.petcalc.presentation.screen.history.list.toEntity
import com.google.android.material.snackbar.Snackbar
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

        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val pos = viewHolder.adapterPosition
                val historyEntity = viewModel.historyItems.value?.get(pos)?.toEntity() ?: return
                viewModel.deleteHistoryItem(historyId = historyEntity.id)

                Snackbar.make(view, "${historyEntity.nickname} Deleted", Snackbar.LENGTH_SHORT).apply {
                    setAction("UNDO") {
                        viewModel.insertHistory(historyEntity)
                    }
                    show()
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(bindingHistoryFragment.recyclerViewHistory)
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