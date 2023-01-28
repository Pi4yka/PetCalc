package com.example.petcalc.screen.second.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.screen.second.model.History
import com.example.petcalc.databinding.RecyclerviewHistoryItemBinding
import com.example.petcalc.screen.second.HistoryFragment

class HistoryAdapter(historyFragment: HistoryFragment) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var historyList: MutableList<History> = mutableListOf()

    class HistoryViewHolder(val binding: RecyclerviewHistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            RecyclerviewHistoryItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = historyList.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyItem = historyList[position]
        holder.binding.nicknameTextView.text = historyItem.nickname
        holder.binding.neckTextView.text = historyItem.neckSize.toString()
        holder.binding.bodyTextView.text = historyItem.bodySize.toString()
        holder.binding.heightTextView.text = historyItem.heightSize.toString()
        holder.binding.sizeTextView.text = historyItem.sizeText

    }

    fun setList(newHistorySizeList: List<History>) {
        historyList = newHistorySizeList.toMutableList()
    }
}