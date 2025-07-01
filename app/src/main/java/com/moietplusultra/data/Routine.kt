package com.moietplusultra.models

data class Routine(
    val id: Int,
    val title: String,
    val isActive: Boolean,
    val recurrence: String,
    val memo: String
)
