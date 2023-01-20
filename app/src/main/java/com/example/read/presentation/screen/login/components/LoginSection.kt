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
    viewModel: LoginViewModel = hiltViewModel(),
    onDone: (String, String, Boolean) -> Unit = { email, pasword, isSignUp -> },
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
    val isSignUp = remember {
        mutableStateOf(false)
    }

    val keyboardController = LocalSoftwareKeyboardController.current

    isPasswordVisible.value = email.value.length > 3

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = if (!isSignUp.value) "Welcome back" else "Use a strong password with at least 6 characters!",
            style = if (!isSignUp.value) MaterialTheme.typography.h3 else MaterialTheme.typography.body1,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            color = AppColors.mTextWhite
        )

        RegisterText() {
            isSignUp.value = !isSignUp.value
            viewModel.isError.value = !viewModel.isError.value
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
                text = if (isSignUp.value) "SIGN UP" else "LOGIN"
            ) {
                if (viewModel.isError.value) {
                    Toast.makeText(context, "Invalid email or password", Toast.LENGTH_LONG).show()
                }
                onDone(email.value.trim(), password.value.trim(), !isSignUp.value)
                if (isSignUp.value)
                    isSignUp.value = !isSignUp.value
            }
        }

    }


}