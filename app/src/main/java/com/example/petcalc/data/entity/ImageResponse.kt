package com.example.petcalc.data.entity

import com.google.gson.annotations.SerializedName

data class ImageDogResponse(
  @SerializedName("message")
  val imageUrl: String?,

  val status: String
)

data class ImageDogBreedResponse(
  @SerializedName("message")
  val imageUrl: String?,

  val status: String?
)