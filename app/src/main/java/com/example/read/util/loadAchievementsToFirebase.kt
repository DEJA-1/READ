package com.example.read.util

import com.example.read.domain.model.Achievement
import com.example.read.presentation.CommonViewModel
import com.example.read.presentation.screen.home.HomeViewModel

fun loadAchievementsToFirebase(achievements: List<Achievement>, viewModel: CommonViewModel) {

    achievements.forEach { achievement ->
        viewModel.addAchievementToFirebase(achievement)
    }

}