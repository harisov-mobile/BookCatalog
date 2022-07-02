package ru.internetcloud.bookcatalog.data.network.dto

import com.google.gson.annotations.SerializedName

data class BookApiResponse(

    @SerializedName("items")
    val items: List<BookItemDTO>
)
