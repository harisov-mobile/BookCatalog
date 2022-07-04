package ru.internetcloud.bookcatalog.domain.repository

import ru.internetcloud.bookcatalog.domain.model.Book
import ru.internetcloud.bookcatalog.domain.model.Result

interface BookRepository {

    suspend fun getBooks(author: String): Result<List<Book>>

    // suspend fun getBookmarks(): Flow<List<Volume>>

    suspend fun setBookmark(volume: Book)

    suspend fun removeBookmark(volume: Book)
}
