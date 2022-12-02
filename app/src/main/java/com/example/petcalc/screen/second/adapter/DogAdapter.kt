package com.example.petcalc.screen.second.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.R
import com.example.petcalc.model.Dog


class DogAdapter(
    private val onDogClickListener: DogClickListener
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {

    private var dogList: MutableList<Dog> = mutableListOf()

    var onItemClick: ((Dog, Int) -> Unit)? = null // обоссаные штаны

    class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dogNameText: TextView = itemView.findViewById(R.id.dogName)
        val dogBreedText: TextView = itemView.findViewById(R.id.dogBreed)
        val dogColorLayout: CardView = itemView.findViewById(R.id.dogLayout)
        val dogConstraint: ConstraintLayout = itemView.findViewById(R.id.dogConstraint)
        val dogImageView: ImageView = itemView.findViewById(R.id.dogImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_list_item, parent, false)
        return DogViewHolder(itemView)
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

        holder.dogNameText.text = dogItem.name
        holder.dogBreedText.text = dogItem.breed
        holder.dogImageView.setImageResource(dogItem.image)
        holder.dogConstraint.setBackgroundResource(colorResource)

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