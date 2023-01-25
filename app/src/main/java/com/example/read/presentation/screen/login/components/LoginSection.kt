package com.example.read.presentation.screen.login.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.read.commons.AppColors
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
            focusedBorderColor = if (viewModel.isError.value || viewModel.isErrorSignUp.value) MaterialTheme.colors.error else AppColors.mMain,
            focusedLabelColor = if (viewModel.isError.value || viewModel.isErrorSignUp.value) MaterialTheme.colors.error else AppColors.mMain,
            modifier = Modifier.fillMaxWidth(),
            onAction = KeyboardActions {
                focusRequester.requestFocus()
            }
        ) {
            if (viewModel.isError.value || viewModel.isErrorSignUp.value)
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = "error icon",
                    tint = MaterialTheme.colors.error
                )
            else {
                Icon(
                    modifier = Modifier.clickable {
                        email.value = ""
                    },
                    imageVector = Icons.Filled.Cancel,
                    contentDescription = "cancel icon",
                    tint = AppColors.mMain
                )
            }
        }

        AnimatedVisibility(
            visible = isPasswordVisible.value
        ) {
            TextInputField(
                valueState = password,
                label = "Password",
                focusedBorderColor = if (viewModel.isError.value || viewModel.isErrorSignUp.value) MaterialTheme.colors.error else AppColors.mMain,
                focusedLabelColor = if (viewModel.isError.value || viewModel.isErrorSignUp.value) MaterialTheme.colors.error else AppColors.mMain,
                isPassword = true,
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                modifier = Modifier
                    .fillMaxWidth()
                    .focusRequester(focusRequester),
                onAction = KeyboardActions {
                    if (!isTextValid) return@KeyboardActions
                    isButtonVisible.value = true
                    keyboardController?.hide()
                }
            ) {
                if (viewModel.isError.value || viewModel.isErrorSignUp.value)
                    Icon(
                        imageVector = Icons.Filled.Error,
                        contentDescription = "error icon",
                        tint = MaterialTheme.colors.error
                    )
                else {
                    Icon(
                        modifier = Modifier.clickable{
                            password.value = ""
                        },
                        imageVector = Icons.Filled.Cancel,
                        contentDescription = "cancel icon",
                        tint = AppColors.mMain
                    )
                }
            }
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