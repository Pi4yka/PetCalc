package com.example.petcalc.screen.second.model

data class History (
    val nickname: String,
    val neckSize: Int,
    val bodySize: Int,
    val heightSize: Int,
    val sizeText: String
        )

fun getMockSizeList(): List<History> {
 return listOf(
     History("Kevin", 45, 38, 36, "M"),
     History("Albert", 75, 48, 66, "XL"),
     History("Maya", 29, 30, 26, "S"),
     History("Kasper", 55, 48, 46, "L"),
    )
}

