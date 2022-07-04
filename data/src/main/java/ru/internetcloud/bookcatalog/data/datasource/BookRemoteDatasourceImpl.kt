package ru.internetcloud.bookcatalog.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.internetcloud.bookcatalog.data.mapper.BookApiMapper
import ru.internetcloud.bookcatalog.data.network.api.BookApiService
import ru.internetcloud.bookcatalog.domain.model.Book
import ru.internetcloud.bookcatalog.domain.model.Result

class BookRemoteDatasourceImpl(
    private val bookApiService: BookApiService,
    private val mapper: BookApiMapper
) : BookRemoteDatasource {

    override suspend fun getBooks(author: String): Result<List<Book>> {
        return withContext(Dispatchers.IO) {
            try {
                val response = bookApiService.getBooks(author)
                if (response.isSuccessful) {
                    response.body()?.let { bookApiResponse ->
                        Result.Success<List<Book>>(mapper.fromListDTOToListEntity(bookApiResponse.items))
                    } ?: let {
                        Result.Success<List<Book>>(emptyList())
                    }
                } else {
                    Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                Result.Error(e)
            }
        }
    }
}
