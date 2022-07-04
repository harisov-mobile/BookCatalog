package ru.internetcloud.bookcatalog.data.datasource

import ru.internetcloud.bookcatalog.domain.model.Book
import ru.internetcloud.bookcatalog.domain.model.Result

interface BookRemoteDatasource {

    suspend fun getBooks(author: String): Result<List<Book>>
}
