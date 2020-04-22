package com.example.homecreditassign.data.model


import com.google.gson.annotations.SerializedName

data class Item(
    val link: String,
    @SerializedName("product_image")
    val productImage: String = "",
    @SerializedName("product_name")
    val productName: String = "",
    @SerializedName("article_image")
    val articleImage: String = "",
    @SerializedName("article_title")
    val articleTitle: String = ""
)