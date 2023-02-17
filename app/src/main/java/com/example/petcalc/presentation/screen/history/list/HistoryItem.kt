package com.example.petcalc.presentation.screen.history.list

import com.example.petcalc.data.entity.HistoryEntity

data class HistoryItem(
    val id: Int,
    val nickname: String,
    val neckSize: Int,
    val bodySize: Int,
    val heightSize: Int,
    val sizeText: String,
    var isExpanded: Boolean
)

fun HistoryItem.toEntity() = HistoryEntity(
    id = this.id,
    nickname = this.nickname,
    neckSize = this.neckSize,
    bodySize = this.bodySize,
    heightSize = this.heightSize,
    sizeText = this.sizeText
)

fun HistoryEntity.toItem() = HistoryItem(
    id = id,
    nickname = nickname,
    neckSize = neckSize,
    bodySize = bodySize,
    heightSize = heightSize,
    sizeText = sizeText,
    isExpanded = false
)


