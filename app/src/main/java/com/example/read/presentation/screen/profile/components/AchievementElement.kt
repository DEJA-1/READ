package com.example.read.presentation.screen.profile.components

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.Achievement

@Composable
fun AchievementElement(
    achievement: Achievement,
    context: Context,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .padding(6.dp)
            .clip(CircleShape)
            .fillMaxSize(0.25f)
            .background(
                if (achievement.isUnlocked)
                    AppColors.mMain
                else
                    Color.DarkGray
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {


        AsyncImage(
            modifier = Modifier
                .fillMaxSize(1f),
            model = ImageRequest.Builder(context)
                .data(achievement.imageUnlocked)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            colorFilter = if (!achievement.isUnlocked) ColorFilter.colorMatrix(ColorMatrix().apply {
                setToSaturation(
                    0f
                )
            }) else ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(1f) }),
            contentDescription = "Achievement Image"
        )

    }

}