package com.example.read.util

import android.content.Context
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.read.domain.model.Achievement
import com.example.read.domain.model.BookFB
import com.example.read.presentation.CommonViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDateTime
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
fun handleAchievementState(
    bookList: List<BookFB>,
    achievementList: List<Achievement>,
    viewModel: CommonViewModel,
    context: Context
) {

    achievementList.forEach { achievement ->

        when (achievement.name) {
            "book" -> {
                if (bookList.isNotEmpty()) {
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)

                    }

                }
            }
            "books" -> {
                if (bookList.size >= 5) {
                    viewModel.updateAchievement(achievement, true)
                }
            }
            "android" -> {
                if (bookList.count { it.categories?.contains("Android") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "law" -> {
                if (bookList.count { it.categories?.contains("Law") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "bulldog" -> {
                if (bookList.count { it.categories?.contains("Pets") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "money" -> {
                if (bookList.count { it.categories?.contains("Business & Economics") == true || it.categories?.contains("Finance, Personal") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "nature" -> {
                if (bookList.count { it.categories?.contains("Gardening") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "realEstate" -> {
                if (bookList.count { it.categories?.contains("bulldog") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
            "business" -> {
                if (bookList.count { it.categories?.contains("Real estate business") == true } >= 3)
                    viewModel.updateAchievement(achievement, true)
            }
        }
    }
}