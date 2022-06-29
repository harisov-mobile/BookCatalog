package ru.internetcloud.bookcatalog.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.internetcloud.bookcatalog.domain.model.Result
import ru.internetcloud.bookcatalog.domain.model.Volume

interface BookRepository {
    suspend fun getRemoteBooks(author: String): Result<List<Volume>>

    suspend fun getBookmarks(): Flow<List<Volume>>

    suspend fun setBookmark(volume: Volume)

    suspend fun removeBookmark(volume: Volume)
}
