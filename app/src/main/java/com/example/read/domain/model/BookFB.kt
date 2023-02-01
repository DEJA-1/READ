package com.example.read.domain.model

import com.google.firebase.firestore.Exclude

data class BookFB(
    val id: String? = null,
    val title: String? = null,
    val authors: String? = null,
    val categories: String? = null,
    val description: String? = null,
    val pageCount: Int? = null,
    val image: String? = null,
    val publishedDate: String? = null,
    val rating: Double? = null,
    val read: Boolean? = null,
    val rated: Boolean? = null,
    val bookId: String? = null,
    val userId: String? = null
)
