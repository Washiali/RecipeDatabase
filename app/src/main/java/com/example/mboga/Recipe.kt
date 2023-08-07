package com.example.mboga

import androidx.room.Entity

@Entity
data class Recipe(
    val name: String,
    val time: String,
    val ingredients:Int,
    val desc:Int,
    val image:Int
)
