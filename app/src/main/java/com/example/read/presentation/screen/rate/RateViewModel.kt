package com.example.read.presentation.screen.rate

import androidx.lifecycle.ViewModel
import com.example.read.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RateViewModel @Inject constructor(
    private val repository: FirebaseRepository
): ViewModel() {



}