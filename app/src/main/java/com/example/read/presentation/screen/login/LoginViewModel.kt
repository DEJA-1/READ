package com.example.read.presentation.screen.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = Firebase.auth

    fun singInWithEmailAndPassword(email: String, password: String, navigate: () -> Unit) {
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful)
                            navigate()
                        else
                            Log.d("Firebase", it.result.toString())
                    }
            } catch (ex: Exception) {
                Log.d("Firebase", "${ex.message}")
            }
        }
    }
}