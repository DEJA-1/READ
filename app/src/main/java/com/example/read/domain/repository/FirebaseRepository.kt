package com.example.read.domain.repository

import com.example.read.domain.model.BookFB

interface FirebaseRepository {

    suspend fun addToFirebase(book: BookFB)
}