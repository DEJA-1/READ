package com.example.read.domain.model

import android.graphics.drawable.Drawable
import android.media.Image
import com.example.read.R

data class Achievement(
    val name: String,
    var isUnlocked: Boolean = false,
    val imageUnlocked: Int
)

fun loadAchievements(): List<Achievement> {
    return listOf(
        Achievement(
            "book",
            true,
            R.drawable.book,
        ),
        Achievement(
            "books",
            false,
            R.drawable.books,
        ),
        Achievement(
            "realEstate",
            true,
            R.drawable.realestate,
        ),
        Achievement(
            "money",
            true,
            R.drawable.money,
        ),
        Achievement(
            "bulldog",
            true,
            R.drawable.bulldog,
        ),
        Achievement(
            "nature",
            false,
            R.drawable.nature,
        ),
        Achievement(
            "law",
            false,
            R.drawable.law,
        ),
        Achievement(
            "android",
            true,
            R.drawable.android,
        ),
        Achievement(
            "business",
            false,
            R.drawable.cooperation,
        ),

        )
}