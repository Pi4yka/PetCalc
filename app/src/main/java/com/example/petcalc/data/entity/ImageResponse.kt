package com.example.petcalc.data.entity

import com.google.gson.annotations.SerializedName

data class ImageResponse(
  @SerializedName("message")
  val imageUrl: String?,

  val status: String?
)