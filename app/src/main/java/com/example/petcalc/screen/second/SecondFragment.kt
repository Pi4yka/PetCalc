package com.example.petcalc.screen.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petcalc.model.*
import androidx.recyclerview.widget.RecyclerView
import com.example.petcalc.screen.second.adapter.DogAdapter
import com.example.petcalc.R
import com.example.petcalc.screen.second.adapter.DogClickListener

class SecondFragment : Fragment(R.layout.fragment_second), DogClickListener {

    private val dogAdapter = DogAdapter(this)
    private val dogList: List<Dog> = getMockDogList()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.dog_list)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = dogAdapter
        dogAdapter.setList(getMockDogList())
    }

    override fun onDogClicked(dog: Dog, position: Int) {
        val newDog = Dog.Dvornyaga(
            name = "asd",
            breed = "asd",
            size = "sad",
            color = Color.BLUE,
            image = R.drawable.bulldog
        )
        dogAdapter.updateItem(position, newDog)
    }

}