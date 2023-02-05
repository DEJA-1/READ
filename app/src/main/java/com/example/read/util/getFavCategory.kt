package com.example.read.util

import android.util.Log
import com.example.read.domain.model.BookFB

fun getFavCategory(bookList: List<BookFB>) : String {

    val categoryCounts = bookList.groupBy { it.categories }.mapValues { (_, group) -> group.size }
    Log.d("Infoa", categoryCounts.toString())
    return categoryCounts.maxByOrNull { (_, count) -> count }?.key ?: "Unknown"
}