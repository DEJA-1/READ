package com.example.read.presentation.screen.login.components

import android.util.Log
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.read.commons.AppColors
import com.example.read.navigation.Screen
import com.example.read.presentation.common_components.MyButton
import com.example.read.presentation.common_components.TextInputField
import com.example.read.presentation.screen.login.LoginViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginSection(
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onDone: (String, String) -> Unit = { email, pasword -> },
) {
    val context = LocalContext.current

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
    val focusRequester = remember {
        FocusRequester()
    }
    //przenies to do viewmodela i potem za pomoca tego wywoluj funkcje, bo jak chce przelaczac meidzy rejestracja a loginem
    //to updatoweanie isSignUp nie nadaza


    val keyboardController = LocalSoftwareKeyboardController.current

    isPasswordVisible.value = email.value.length > 3

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = if (!viewModel.isSignUp.value) "Welcome back" else "Use a strong password with at least 6 characters!",
            style = if (!viewModel.isSignUp.value) MaterialTheme.typography.h3 else MaterialTheme.typography.body1,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = AppColors.mTextWhite
        )

        RegisterText() {
            viewModel.handleSingUp()
        }

        TextInputField(
            valueState = email,
            label = "Email",
            modifier = Modifier.fillMaxWidth(),
            onAction = KeyboardActions {
                focusRequester.requestFocus()
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
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                onAction = KeyboardActions {
                    if (!isTextValid) return@KeyboardActions
//                    email.value = email.value.split('@').first()
                    isButtonVisible.value = true
                    keyboardController?.hide()
                }
            )
        }

        AnimatedVisibility(
            visible = isButtonVisible.value
        ) {
            MyButton(
                modifier = Modifier.padding(top = 8.dp),
                text = if (viewModel.isSignUp.value) "SIGN UP" else "LOGIN"
            ) {
                keyboardController?.hide()
                onDone(email.value.trim(), password.value.trim())
            }
        }

    }


}