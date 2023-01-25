package com.example.read.data.network.response

data class Offer(
    val finskyOfferType: Int,
    val listPrice: ListPriceX,
    val retailPrice: RetailPrice
)