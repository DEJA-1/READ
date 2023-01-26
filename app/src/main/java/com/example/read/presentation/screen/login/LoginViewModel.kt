package com.example.read.presentation.screen.login

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.domain.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginViewModel(
) : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    private val _isError = mutableStateOf(false)
    val isError = _isError

    private val _isErrorSignUp = mutableStateOf(false)
    val isErrorSignUp = _isErrorSignUp

    private val _isSignUp = mutableStateOf(false)
    val isSignUp = _isSignUp

    fun singInWithEmailAndPassword(
        context: Context? = null,
        email: String,
        password: String,
        navigate: () -> Unit
    ) {
        viewModelScope.launch {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        _isError.value = false
                        navigate()
                    } else {
                        _isError.value = true
                        Toast.makeText(context, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }

    fun createUserWithEmailAndPassword(
        context: Context? = null,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val displayName = it.result.user?.email?.split('@')?.first()
                        createUser(displayName)

                        _isSignUp.value = false
                        _isErrorSignUp.value = false

                        Toast.makeText(context, "Account created", Toast.LENGTH_SHORT).show()
                    } else {
                        _isSignUp.value = true
                        _isErrorSignUp.value = true
                        Toast.makeText(context, "${it.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }
    }
    private fun createUser(displayName: String?) {
        val user = User(
            userId = auth.currentUser?.uid.toString(),
            displayName = displayName.toString(),
            id = null
        )

        FirebaseFirestore.getInstance().collection("users")
            .add(user)
    }

    fun handleSingUp() {
        _isSignUp.value = !_isSignUp.value
    }
}