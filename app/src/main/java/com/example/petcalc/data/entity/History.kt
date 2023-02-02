package com.example.petcalc.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HISTORY")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nickname: String,
    val neckSize: Int,
    val bodySize: Int,
    val heightSize: Int,
    val sizeText: String
)
