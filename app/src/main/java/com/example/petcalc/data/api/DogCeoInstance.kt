package com.example.petcalc.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object DogCeoInstance {

    val api: DogCeoService by lazy {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DogCeoService::class.java)
    }
}

