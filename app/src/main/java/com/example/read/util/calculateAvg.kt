package com.example.read.util

import com.example.read.domain.model.BookFB

fun calculateAvg(bookList: List<BookFB>): Double {
    var ratingSum = 0
    bookList.forEach {
        ratingSum += it.rating
    }
    if (bookList.isEmpty())
        return 0.0
    val num = (ratingSum / bookList.size).toDouble()
    return String.format("%.2f", num).toDouble()
}

