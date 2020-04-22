package com.example.homecreditassign.data.model


import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("items")
    val itemProducts: List<Item>,
    val section: String,
    @SerializedName("section_title")
    val sectionTitle: String
)