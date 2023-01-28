package com.example.read.domain.model

import com.example.read.data.network.response.VolumeInfo
import com.google.firebase.auth.FirebaseAuth

data class MyItem(
    val id: String?,
    val selfLink: String?,
    val volumeInfo: VolumeInfo?
)

fun MyItem.toBookFB(): BookFB {
    return BookFB(
        title = volumeInfo?.title,
        authors = volumeInfo?.authors.toString(),
        categories = volumeInfo?.categories.toString(),
        description = volumeInfo?.description,
        pageCount = volumeInfo?.pageCount,
        image = volumeInfo?.imageLinks?.thumbnail,
        publishedDate = volumeInfo?.publishedDate,
        rating = 0.0,
        bookId = id,
        userId = FirebaseAuth.getInstance().currentUser?.uid.toString()
    )
}
