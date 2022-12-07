package com.example.petcalc.screen.third.adapter

import Diablo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.databinding.DiabloListItemBinding
import com.example.petcalc.screen.third.DiabloDiffUtil


class DiabloAdapter() : RecyclerView.Adapter<DiabloAdapter.DiabloViewHolder>() {

    private var oldDiabloList = emptyList<Diablo>()

    class DiabloViewHolder(val binding: DiabloListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiabloViewHolder {
        return DiabloViewHolder(DiabloListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: DiabloViewHolder, position: Int) {
        holder.binding.diabloName.text = oldDiabloList[position].name
        holder.binding.buildText.text = oldDiabloList[position].build
        holder.binding.diabloImg.setImageResource(oldDiabloList[position].image)
    }

    override fun getItemCount(): Int {
     return oldDiabloList.size
    }

    fun setData(newDiabloList: List<Diablo>){
        val diffUtil = DiabloDiffUtil(oldDiabloList,newDiabloList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldDiabloList = newDiabloList
        diffResult.dispatchUpdatesTo(this)
    }

}