package ru.internetcloud.bookcatalog.data.network.dto

import com.google.gson.annotations.SerializedName

data class BookItemDTO(

    @SerializedName("id")
    val id: String,

    @SerializedName("etag")
    val etag: String,

    @SerializedName("selflink")
    val selflink: String,

    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfoDTO
)
