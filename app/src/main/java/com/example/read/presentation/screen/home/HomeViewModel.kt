package com.example.read.presentation.screen.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class HomeViewModel : ViewModel() {

    val currentUser = FirebaseAuth.getInstance().currentUser

    private val _isBookRead = mutableStateOf(false)
    val isBookRead = _isBookRead

    private val _isCardExpanded = mutableStateOf(false)
    val isCardExpanded = _isCardExpanded

    fun changeReadState() {
        _isBookRead.value = !_isBookRead.value
    }

    fun changeCardExpandedState() {
        _isCardExpanded.value = !_isCardExpanded.value
    }
}