package com.example.petcalc.data.repository

import com.example.petcalc.data.DogCeoService
import com.example.petcalc.data.entity.Breed
import com.example.petcalc.data.entity.ImageDogBreedResponse
import com.example.petcalc.data.entity.ImageDogResponse
import com.example.petcalc.util.RequestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepositoryIml @Inject constructor(
    private val dogCeoService: DogCeoService
): DogRepository {

    override suspend fun getDogs(): RequestResult<ImageDogResponse> {
        return withContext(Dispatchers.IO) {
            try {
                RequestResult.Success(dogCeoService.getDogImage())
            } catch (e: Exception) {
                RequestResult.Error(e.message.orEmpty())
            }
        }
    }

    override suspend fun getBreedDogs(breed: String): RequestResult<ImageDogBreedResponse> {
        return withContext(Dispatchers.IO) {
            try {
                RequestResult.Success(dogCeoService.getDogImageByBreed(breed))
            } catch (e: Exception) {
                RequestResult.Error(e.message.orEmpty())
            }
        }
    }

}