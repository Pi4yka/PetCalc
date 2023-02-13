package com.example.petcalc.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nickname: String,
    val neckSize: Int,
    val bodySize: Int,
    val heightSize: Int ,
    val sizeText: String
)
