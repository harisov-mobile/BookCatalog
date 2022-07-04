package ru.internetcloud.bookcatalog.domain.model

data class Book(
    val id: String,
    val title: String,
    val authors: List<String>?,
    val imageUrl: String?,
    val publishedYear: Int,
    var bookmarked: Boolean
)
