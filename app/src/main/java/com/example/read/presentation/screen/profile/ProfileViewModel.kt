package com.example.read.presentation.screen.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.read.commons.Resource
import com.example.read.domain.model.Achievement
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.loadAchievements
import com.example.read.domain.repository.FirebaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val repository: FirebaseRepository,
) : ViewModel() {
    private val _isLoading = mutableStateOf(true)
    val isLoading = _isLoading

    private val _booksFromFB = mutableStateOf(listOf<BookFB>())
    val booksFromFB = _booksFromFB

    private val errorMessage = mutableStateOf("")

    private val _achievementList = mutableStateOf(listOf<Achievement>())
    val achievementList = _achievementList

    init {
        getBooksFromFB()
        getAchievementList()
    }

    private fun getBooksFromFB() {
        viewModelScope.launch {
            delay(200L)
            _isLoading.value = true
            val result = repository.getBooksFromFB()

            when (result) {
                is Resource.Success -> {
                    _booksFromFB.value = result.data!!
                    _isLoading.value = false
                }

                is Resource.Error -> {
                    errorMessage.value = result.message!!
                    _isLoading.value = false
                }

                else -> {}
            }
        }
    }

    private fun getAchievementList() {
        _achievementList.value = loadAchievements()
    }
    fun updateAchievementStatus(achievement: Achievement) {
        achievement.isUnlocked = true
    }
}