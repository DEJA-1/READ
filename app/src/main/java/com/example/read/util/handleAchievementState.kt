package com.example.read.util

import com.example.read.domain.model.Achievement
import com.example.read.domain.model.BookFB
import com.example.read.presentation.CommonViewModel

fun handleAchievementState(
    bookList: List<BookFB>,
    achievementList: List<Achievement>,
    viewModel: CommonViewModel,
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
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
                }
            }
            "android" -> {
                if (bookList.count { it.categories?.contains("Android") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "law" -> {
                if (bookList.count { it.categories?.contains("Law") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "bulldog" -> {
                if (bookList.count { it.categories?.contains("Pets") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "money" -> {
                if (bookList.count {
                        it.categories?.contains("Business & Economics") == true || it.categories?.contains(
                            "Finance, Personal"
                        ) == true
                    } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "nature" -> {
                if (bookList.count { it.categories?.contains("Gardening") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "realEstate" -> {
                if (bookList.count { it.categories?.contains("bulldog") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
            "business" -> {
                if (bookList.count { it.categories?.contains("Real estate business") == true } >= 3)
                    if (!achievement.isUnlocked) {
                        viewModel.updateAchievement(achievement, true)
                    }
            }
        }
    }
}