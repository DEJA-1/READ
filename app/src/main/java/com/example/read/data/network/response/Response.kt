package com.example.read.data.network.response

import com.example.read.domain.model.MyItems

data class Response(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int,
)

fun Response.toMyItems(): MyItems {
    return MyItems(
        items = items.map { it.toMyItem() }
    )
}