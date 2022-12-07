package com.example.petcalc.screen.third

import Diablo
import androidx.recyclerview.widget.DiffUtil

class DiabloDiffUtil(
    private val oldList: List<Diablo>,
    private val newList: List<Diablo>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id != newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id ->{
                false
            }
            oldList[oldItemPosition].name != newList[newItemPosition].name ->{
                false
            }
            oldList[oldItemPosition].build != newList[newItemPosition].build ->{
                false
            }
            else -> true
        }


    }
}