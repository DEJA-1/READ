package com.example.read.domain.model

import android.graphics.drawable.Drawable
import android.media.Image
import com.example.read.R
import com.google.firebase.Timestamp

data class Achievement(
    val id: String? = null,
    val name: String = "",
    var isUnlocked: Boolean = false,
    var unlockedAt: Timestamp? = null,
    val imageUnlocked: String = "",
    val description: String = "",
    val userId: String? = null,
)

fun loadAchievements(): List<Achievement> {
    return listOf(
        Achievement(
            name = "book",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2436/2436729.png",
            description = "Read one book"
        ),
        Achievement(
            name = "books",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3330/3330314.png",
            description = "Read three books"
        ),
        Achievement(
            name = "realEstate",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3796/3796856.png",
            description = "Read three books about real estate"
        ),
        Achievement(
            name = "money",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2704/2704332.png",
            description = "Read three books about business and finance"
        ),
        Achievement(
            name = "bulldog",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2172/2172063.png",
            description = "Read three books about pets"
        ),
        Achievement(
            name = "nature",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/119/119591.png",
            description = "Read three books about environment"
        ),
        Achievement(
            name = "law",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3122/3122427.png",
            description = "Read three books about law"
        ),
        Achievement(
            name = "android",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/2222/2222807.png",
            description = "Read three books about android"
        ),
        Achievement(
            name = "business",
            isUnlocked = false,
            imageUnlocked = "https://cdn-icons-png.flaticon.com/512/3281/3281412.png",
            description = "Read three books about business"
        ),

        )
}