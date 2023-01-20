package com.example.read.presentation.screen.login

import android.util.Log
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

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth
    val isError = mutableStateOf(false)

    fun singInWithEmailAndPassword(
        email: String,
        password: String,
        navigate: () -> Unit
    ) {
        viewModelScope.launch {

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful)
                        navigate()
                    else {
                        Log.d("Firebase", "${it.exception?.message}")
                        if (it.exception is FirebaseAuthException) {
                            isError.value = true
                            Log.d("ele", "${isError.value}")
                        }
                    }

                }
        }
    }

    fun createUserWithEmailAndPassword(email: String, password: String) {
        viewModelScope.launch {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        val displayName = it.result.user?.email?.split('@')?.first()
                        createUser(displayName)
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
}