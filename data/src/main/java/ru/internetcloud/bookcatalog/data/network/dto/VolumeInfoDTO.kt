package ru.internetcloud.bookcatalog.data.network.dto

import com.google.gson.annotations.SerializedName

data class VolumeInfoDTO(

    @SerializedName("title")
    val title: String,

    @SerializedName("subtitle")
    val subtitle: String,

    @SerializedName("authors")
    val authors: List<String>,

    @SerializedName("publishedDate")
    val publishedDate: String,

    @SerializedName("pageCount")
    val pageCount: Int,

    @SerializedName("categories")
    val categories: List<String>,

    @SerializedName("language")
    val language: String,

    @SerializedName("imageLinks")
    val imageLinks: ImageLinksDTO
)
