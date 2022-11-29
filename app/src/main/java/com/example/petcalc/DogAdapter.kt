package com.example.petcalc

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.model.Dog


class DogAdapter(
    private val dogs: List<Dog>
    ):RecyclerView.Adapter<DogAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val dogNameText: TextView = itemView.findViewById(R.id.dogName)
        val dogBreedText: TextView = itemView.findViewById(R.id.dogBreed)
        val dogColorLayout: LinearLayout = itemView.findViewById(R.id.dogLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.dog_list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.dogNameText.text = dogs[position].name
        holder.dogBreedText.text = dogs[position].breed
//        holder.dogColorLayout.setBackgroundColor(Color.parseColor(dogs[position].color.toString()))
    }

    override fun getItemCount() = dogs.size

}