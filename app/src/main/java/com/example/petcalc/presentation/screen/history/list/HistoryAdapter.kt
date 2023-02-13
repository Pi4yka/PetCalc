package com.example.petcalc.presentation.screen.history.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.data.entity.HistoryEntity
import com.example.petcalc.databinding.RecyclerviewHistoryItemBinding
import javax.inject.Inject

class HistoryAdapter @Inject constructor(): RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    private var historyList: MutableList<HistoryItem> = mutableListOf()

    class HistoryViewHolder(val binding: RecyclerviewHistoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

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

    private fun getSwitcherArrowResId(isExpanded: Boolean): Int =
        if (isExpanded) R.drawable.ic_arrow_up else R.drawable.ic_arrow_down

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val historyItem = historyList[position]
        val isExpanded = historyItem.isExpanded

        holder.binding.nicknameTextView.text = historyItem.nickname
        holder.binding.neckTextView.text = historyItem.neckSize.toString()
        holder.binding.bodyTextView.text = historyItem.bodySize.toString()
        holder.binding.heightTextView.text = historyItem.heightSize.toString()
        holder.binding.sizeTextView.text = historyItem.sizeText
        holder.binding.switcherArrow.setImageResource(getSwitcherArrowResId(isExpanded))
        holder.binding.expandedLayout.visibility = if (isExpanded) View.VISIBLE else View.GONE

        holder.binding.mainLayout.setOnClickListener {
            historyItem.isExpanded = !isExpanded
            holder.binding.switcherArrow.setImageResource(getSwitcherArrowResId(isExpanded))
            notifyItemChanged(position)
        }
    }

    fun setList(): Int = differ.currentList.size

    private val differCallback = object :
    DiffUtil.ItemCallback<HistoryEntity>(){
        override fun areItemsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HistoryEntity, newItem: HistoryEntity): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
}