package com.moietplusultra.models

data class Habitude(
    val id: Int,
    val title: String,
    val currentStreak: Int,
    val bestStreak: Int,
    val isSkippedToday: Boolean
)
