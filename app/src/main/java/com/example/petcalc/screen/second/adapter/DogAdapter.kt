package com.example.petcalc.screen.second.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.databinding.DogListItemBinding
import com.example.petcalc.model.Dog


class DogAdapter(
    private val onDogClickListener: DogClickListener
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private var dogList: MutableList<Dog> = mutableListOf()

    private var onItemClick: ((Dog, Int) -> Unit)? = null // обоссаные штаны // теперь нет

    class DogViewHolder(val binding: DogListItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(DogListItemBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val dogItem = dogList[position]
        val colorResource = when (dogItem.color.toString()) {
            "BLACK" -> R.color.black
            "BROWN" -> R.color.brown
            "WHITE" -> R.color.white
            "GREEN" -> R.color.green
            "BLUE" -> R.color.blue
            "GREY" -> R.color.grey
            else -> R.color.purple_200
        }

        holder.binding.dogName.text = dogItem.name
        holder.binding.dogBreed.text = dogItem.breed
        holder.binding.dogImage.setImageResource(dogItem.image)
        holder.binding.dogConstraint.setBackgroundResource(colorResource)

        holder.itemView.setOnClickListener {
            this.onDogClickListener.onDogClicked(dogItem, position)
        }
    }

    fun setList(newDogList: List<Dog>) {
        dogList = newDogList.toMutableList()
    }

    fun updateItem(index: Int, newItem: Dog) {
        dogList.set(index, newItem)
        this.notifyItemChanged(index)
    }

    override fun getItemCount() = dogList.size

}