package com.example.petcalc.data

import com.example.petcalc.data.entity.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogCeoService {
    @GET("/api/breeds/image/random")
    suspend fun getDogImageByBreed(): Response<ImageResponse>
//    @GET("api/breed/{breed}/images/random")
//    suspend fun getDogImageByBreed(@Path("breed") breed: String): Response<ImageByBreedResponse>
}
