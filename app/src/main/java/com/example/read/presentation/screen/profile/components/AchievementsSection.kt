package com.example.read.presentation.screen.profile.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors
import com.example.read.domain.model.Achievement
import com.example.read.presentation.screen.profile.components.AchievementElement

@Composable
fun AchievementsSection(
    achievementList: List<Achievement>,
    context: Context
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp),
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                modifier = Modifier.align(CenterHorizontally).padding(8.dp),
                text = "ACHIEVEMENTS",
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 26.sp,
                color = AppColors.mTextWhite,
                textAlign = TextAlign.Center
            )

            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.8f),
                columns = GridCells.Fixed(4)) {
                items(achievementList) { achievement ->
                    AchievementElement(achievement = achievement, context = context) {

                    }
                }
            }

        }
    }
}