package com.example.petcalc.screen.second.adapter

import com.example.petcalc.model.Dog

interface DogClickListener {
    fun onDogClicked(dog: Dog, position: Int)
}