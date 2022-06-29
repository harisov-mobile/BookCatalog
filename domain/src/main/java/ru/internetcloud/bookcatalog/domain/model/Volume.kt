package ru.internetcloud.bookcatalog.domain.model

data class Volume(
    val id: String,
    val title: String,
    val authors: List<String>,
    val imageUrl: String?
)
