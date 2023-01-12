package com.example.petcalc.data.repository

import com.example.petcalc.data.entity.Breed
import com.example.petcalc.data.entity.ImageResponse
import com.example.petcalc.util.RequestResult

interface DogRepository {
    suspend fun getDogs(): RequestResult<ImageResponse>
}