package ru.internetcloud.bookcatalog.data.network.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://www.googleapis.com/books/v1/"

class BookApiClient {
    private val okHttpClient: OkHttpClient =
        OkHttpClient.Builder()
            // .addInterceptor(BasicAuthInterceptor(authParameters.login, authParameters.password))
            .build()

    // необходимо эту переменную поместить ниже, чем okHttpClient
    // т.к. сначала должна пройти инициализация переменной okHttpClient
    val client: BookApiService = getRetrofit().create(BookApiService::class.java)

    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit
    }
}
