package com.example.read.domain.model

import com.example.read.data.network.response.VolumeInfo

data class MyItem(
    val id: String?,
    val selfLink: String?,
    val volumeInfo: VolumeInfo?
)
