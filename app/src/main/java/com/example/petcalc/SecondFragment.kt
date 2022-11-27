package com.example.petcalc

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class SecondFragment: Fragment(R.layout.fragment_second) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}