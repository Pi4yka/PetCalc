package com.example.petcalc.data

import com.example.petcalc.data.entity.ImageResponse
import com.example.petcalc.util.RequestResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DogCeoService {
    @GET("/api/breeds/image/random")
    suspend fun getDogImageByBreed(): ImageResponse

//    @GET("api/breed/{breed}/images/random")
//    suspend fun getDogImageByBreed(@Path("breed") breed: String): ImageByBreedResponse>
}
