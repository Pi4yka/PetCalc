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
                val historyId = viewModel.historyItems.value?.get(pos)
                val historyItem = HistoryEntity(
                    nickname = historyId!!.nickname,
                    neckSize = historyId.neckSize,
                    bodySize = historyId.bodySize,
                    heightSize = historyId.heightSize,
                    sizeText = historyId.sizeText
                )
                viewModel.deleteHistoryItem(historyId = historyId.id)
                Snackbar.make(view, "Item Deleted", Snackbar.LENGTH_SHORT).apply {
                    setAction("UNDO") {
                        viewModel.insertHistory(historyItem)
                        historyAdapter.notifyDataSetChanged()
                    }
                    show()
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(bindingHistoryFragment.recyclerViewHistory)
        viewModel.fetchHistoryList()
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