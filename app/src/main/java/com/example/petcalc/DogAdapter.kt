package com.example.petcalc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.model.Dog


class DogAdapter(
    private val dogs: List<Dog>
    ):RecyclerView.Adapter<DogAdapter.MyViewHolder>(){

    var onItemClick : ((Dog) -> Unit)? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val dogNameText: TextView = itemView.findViewById(R.id.dogName)
        val dogBreedText: TextView = itemView.findViewById(R.id.dogBreed)
        val dogColorLayout: CardView = itemView.findViewById(R.id.dogLayout)
        val dogImageView: ImageView = itemView.findViewById(R.id.dogImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dogsList = dogs[position]
        val colorResource = when(dogsList.color.toString()){
            "BLACK" -> R.color.black
            "BROWN" -> R.color.brown
            "WHITE" -> R.color.white
            "GREEN" -> R.color.green
            "BLUE" -> R.color.blue
            "GREY" -> R.color.grey
            else -> R.color.purple_200
        }

        holder.dogNameText.text = dogsList.name
        holder.dogBreedText.text = dogsList.breed
        holder.dogImageView.setImageResource(dogsList.image)
        holder.dogColorLayout.setBackgroundResource(colorResource)

        holder.itemView.setOnClickListener{
            println(dogsList)
            onItemClick?.invoke(dogsList)
        }
    }

    override fun getItemCount() = dogs.size


}