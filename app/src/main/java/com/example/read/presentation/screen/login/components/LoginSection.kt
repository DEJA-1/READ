package com.example.read.presentation.screen.login.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.read.commons.AppColors
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.common_components.TextInputField

@OptIn(ExperimentalComposeUiApi::class)
@Preview
@Composable
fun LoginSection() {
    val email = remember {
        mutableStateOf("")
    }
    val password = remember {
        mutableStateOf("")
    }
    val isPasswordVisible = remember {
        mutableStateOf(false)
    }
    val isButtonVisible = remember {
        mutableStateOf(false)
    }
    val isTextValid = remember(email.value, password.value) {
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    isPasswordVisible.value = email.value.isNotEmpty()

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Welcome back",
            style = MaterialTheme.typography.h3,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = AppColors.mTextWhite
        )

        TextInputField(
            valueState = email,
            label = "Email",
            modifier = Modifier.fillMaxWidth(),
            onAction = KeyboardActions {

            }
        )

        AnimatedVisibility(
            visible = isPasswordVisible.value
        ) {
            TextInputField(
                valueState = password,
                label = "Password",
                isPassword = true,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                modifier = Modifier.fillMaxWidth(),
                onAction = KeyboardActions {
                    if (!isTextValid) return@KeyboardActions
                    email.value = email.value.split('@').first()
                    isButtonVisible.value = !isButtonVisible.value
                    keyboardController?.hide()
                }
            )
        }

        AnimatedVisibility(
            visible = isButtonVisible.value
        ) {
            MyButton()
        }

    }


}