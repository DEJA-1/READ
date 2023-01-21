package com.example.read.presentation.screen.home

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    val currentUser = FirebaseAuth.getInstance().currentUser
}