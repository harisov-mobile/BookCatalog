package ru.internetcloud.bookcatalog.data.datasource

import ru.internetcloud.bookcatalog.domain.model.Result
import ru.internetcloud.bookcatalog.domain.model.Volume

interface BookRemoteDatasource {

    suspend fun getBooks(author: String): Result<List<Volume>>
}
