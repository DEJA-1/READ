package com.example.read.presentation.screen.profile.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.read.commons.AppColors
import com.example.read.domain.model.Achievement
import java.text.SimpleDateFormat

@Composable
fun MyAlertDialog(openDialog: MutableState<Boolean>, achievement: Achievement, context: Context) {

    if (openDialog.value) {
        Dialog(onDismissRequest = { openDialog.value = false }) {
            CustomDialogUi(openDialogCustom = openDialog, achievement)
        }
    }
}

@Preview
@Composable
fun CustomDialogUi(
    openDialogCustom: MutableState<Boolean> = mutableStateOf(false),
    achievement: Achievement = Achievement(),
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .size(280.dp, 280.dp)
            .padding(10.dp, 10.dp, 10.dp, 10.dp),
        elevation = 8.dp,
        backgroundColor = AppColors.mBackgroundSec
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(6.dp)
                    .clip(RoundedCornerShape(360.dp))
                    .fillMaxSize(0.25f)
                    .background(AppColors.mMain)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize(1f),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(achievement.imageUnlocked)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Achievement Image"
                )

            }

            Column(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 8.dp
                ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxWidth(),
                    text = achievement.description,
                    textAlign = TextAlign.Center,
                    color = AppColors.mTextWhite,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )


                val dateFormat = SimpleDateFormat("dd/MM/yyyy")
                val formattedDate = if(achievement.unlockedAt == null) "Not unlocked yet" else dateFormat.format(
                    achievement.unlockedAt!!.toDate())
                Text(
                    text = "Acquired: $formattedDate",
                    textAlign = TextAlign.Center,
                    color = AppColors.mTextWhite,
                    modifier = Modifier
                        .padding(top = 10.dp, start = 25.dp, end = 25.dp),
                    fontSize = 13.sp
                )
            }

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background(AppColors.mMain),
                    horizontalArrangement = Arrangement.Center
                ) {

                    TextButton(onClick = { openDialogCustom.value = false }) {
                        Text(
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp),
                            text = "Done",
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    }

                }
            }

        }

    }

}