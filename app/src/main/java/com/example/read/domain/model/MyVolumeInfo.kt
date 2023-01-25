package com.example.read.domain.model

import com.example.read.data.network.response.ImageLinks

data class MyVolumeInfo(

    val authors: List<String>?,
    val categories: List<String>?,
    val description: String?,
    val imageLinks: ImageLinks?,
    val pageCount: Int?,
    val publishedDate: String?,
    val subtitle: String?,
    val title: String

)
