package com.example.petcalc.presentation.screen.history.list

import androidx.recyclerview.widget.DiffUtil
import com.example.petcalc.presentation.screen.history.list.HistoryItem

class HistoryDiffUtil(
    private val oldListItem: List<HistoryItem>,
    private val newListItem: List<HistoryItem>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldListItem.size

    override fun getNewListSize(): Int = newListItem.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListItem[oldItemPosition].id == newListItem[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldListItem[oldItemPosition] == newListItem[newItemPosition]
    }
}