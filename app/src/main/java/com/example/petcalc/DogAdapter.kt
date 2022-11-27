package com.example.petcalc

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.model.Dog

class DogAdapter(
    var dogs: List<Dog>
) : RecyclerView.Adapter<DogAdapter.DogViewHolder>() {
    inner class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return dogs.size
    }
}