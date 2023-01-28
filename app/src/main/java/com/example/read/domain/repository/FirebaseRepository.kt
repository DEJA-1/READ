package com.example.read.domain.repository

import com.example.read.commons.Resource
import com.example.read.domain.model.BookFB
import com.example.read.domain.model.MyItem

interface FirebaseRepository {

    suspend fun addToFirebase(book: BookFB)

    suspend fun getBooksFromFB(): Resource<List<BookFB>>
}