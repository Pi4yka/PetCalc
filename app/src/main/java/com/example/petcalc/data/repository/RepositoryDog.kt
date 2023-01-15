package com.example.petcalc.data.repository

import com.example.petcalc.data.entity.Breed
import com.example.petcalc.data.entity.ImageDogBreedResponse
import com.example.petcalc.data.entity.ImageDogResponse
import com.example.petcalc.util.RequestResult

interface DogRepository {
    suspend fun getDogs(): RequestResult<ImageDogResponse>
    suspend fun getBreedDogs(breed: String): RequestResult<ImageDogBreedResponse>
}