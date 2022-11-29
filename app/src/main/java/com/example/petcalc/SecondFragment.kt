package com.example.petcalc

import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcalc.model.*
import androidx.recyclerview.widget.RecyclerView

class SecondFragment: Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.dog_list)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = DogAdapter(fillList())
    }

    private fun fillList(): List<Dog> {
        val data: List<Dog> = listOf(
            zevs, kasper, tom, demon, andreas
        )
        return data

    }
}