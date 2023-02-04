package com.example.read.presentation.screen.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.read.commons.AppColors

@Composable
fun Header(
    modifier: Modifier = Modifier,
    nick: String = "Test",
    isProfile: Boolean = false,
    icon: ImageVector = Icons.Filled.AccountCircle,
    onIconClick: () -> Unit
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                buildAnnotatedString {

                    if (!isProfile) {
                        withStyle(
                            SpanStyle(
                                color = AppColors.mTextWhite,
                                fontWeight = FontWeight.Medium,
                                fontSize = 26.sp,
                            )
                        ) {
                            append("Hello, ")
                        }

                    }
                    withStyle(
                        SpanStyle(
                            color = AppColors.mMain,
                            fontWeight = FontWeight.ExtraBold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 26.sp,
                        )
                    ) {
                        append(nick.uppercase())
                    }
                }
            )

            if (!isProfile) {
                Text(
                    text = "Happy reading!",
                    color = AppColors.mTextWhite,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                )
            }

        }
        Icon(
            modifier = modifier.size(64.dp)
                .clickable {
                    onIconClick()
                },
            imageVector = icon,
            contentDescription = "account icon",
            tint = AppColors.mMain
        )
    }


}