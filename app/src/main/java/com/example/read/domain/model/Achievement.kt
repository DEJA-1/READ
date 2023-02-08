package com.example.read.domain.model

import android.graphics.drawable.Drawable
import android.media.Image
import com.example.read.R

data class Achievement(
    val id: String? = null,
    val name: String = "",
    var isUnlocked: Boolean = false,
    val imageUnlocked: String = "",
    val userId: String? = null,
)

fun loadAchievements(): List<Achievement> {
    return listOf(
        Achievement(
            name = "book",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2436/2436729.png",
        ),
        Achievement(
            name = "books",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3330/3330314.png"
        ),
        Achievement(
            name = "realEstate",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3796/3796856.png",
        ),
        Achievement(
            name = "money",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2704/2704332.png",
        ),
        Achievement(
            name = "bulldog",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2172/2172063.png",
        ),
        Achievement(
            name = "nature",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/119/119591.png",
        ),
        Achievement(
            name = "law",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3122/3122427.png",
        ),
        Achievement(
            name = "android",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2222/2222807.png",
        ),
        Achievement(
            name = "business",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3281/3281412.png",
        ),

        )
}