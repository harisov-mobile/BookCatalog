package ru.internetcloud.bookcatalog.data.network.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.internetcloud.bookcatalog.data.network.dto.BookApiResponse

interface BookApiService {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q")
        author: String
    ): Response<BookApiResponse>
}