package com.example.petcalc.data.repository

import com.example.petcalc.data.DogCeoService
import com.example.petcalc.data.entity.ImageResponse
import com.example.petcalc.util.RequestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DogRepositoryIml @Inject constructor(
    private val dogCeoService: DogCeoService
): DogRepository {

    override suspend fun getDogs(): RequestResult<ImageResponse> {
        return withContext(Dispatchers.IO) {
            try {
                RequestResult.Success(dogCeoService.getDogImageByBreed())
            } catch (e: Exception) {
                RequestResult.Error(e.message.orEmpty())
            }
        }
    }

}