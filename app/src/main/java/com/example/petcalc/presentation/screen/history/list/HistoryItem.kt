package com.example.petcalc.presentation.screen.history.list

import com.example.petcalc.data.entity.History

data class HistoryItem(
    val nickname: String,
    val neckSize: Int,
    val bodySize: Int,
    val heightSize: Int,
    val sizeText: String,
    var isExpanded: Boolean
)

fun History.toItem() = HistoryItem(
    nickname = nickname,
    neckSize = neckSize,
    bodySize = bodySize,
    heightSize = heightSize,
    sizeText = sizeText,
    isExpanded = false
)

fun getMockHistoryItemList(): List<HistoryItem> {
    return listOf(
        HistoryItem("Kevin", 45, 38, 36, "M", false),
        HistoryItem("Albert", 75, 48, 66, "XL", false),
        HistoryItem("Maya", 29, 30, 26, "S", false),
        HistoryItem("Kasper", 55, 48, 46, "L", false),
    )
}

