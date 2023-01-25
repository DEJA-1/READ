package com.example.read.data.network.response

import com.example.read.domain.model.MyItem

data class Item(
    val accessInfo: AccessInfo,
    val etag: String,
    val id: String,
    val kind: String,
    val saleInfo: SaleInfo,
    val searchInfo: SearchInfo,
    val selfLink: String,
    val volumeInfo: VolumeInfo
)

fun Item.toMyItem(): MyItem {
    return MyItem(
        id = id,
        selfLink = selfLink,
        volumeInfo = volumeInfo
    )
}