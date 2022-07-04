package ru.internetcloud.bookcatalog.presentation.book_list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.internetcloud.bookcatalog.data.database.BookmarkDatabase
import ru.internetcloud.bookcatalog.data.datasource.BookLocalDataSourceImpl
import ru.internetcloud.bookcatalog.data.datasource.BookRemoteDatasourceImpl
import ru.internetcloud.bookcatalog.data.mapper.BookApiMapper
import ru.internetcloud.bookcatalog.data.mapper.BookDbMapper
import ru.internetcloud.bookcatalog.data.network.api.BookApiClient
import ru.internetcloud.bookcatalog.data.repository.BookRepositoryImpl
import ru.internetcloud.bookcatalog.domain.model.Result
import ru.internetcloud.bookcatalog.domain.model.Volume
import ru.internetcloud.bookcatalog.domain.usecase.GetBooksUseCase

class BookListViewModel : ViewModel() {

    private val _result = MutableLiveData<Result<List<Volume>>>()
    val result: LiveData<Result<List<Volume>>>
    get() = _result

//    init {
//        fetchBooks()
//    }

    fun fetchBooks(app: Application) {
        viewModelScope.launch {
            val author = "Ildar Kharisov"

            val dao = BookmarkDatabase.getInstance(app).bookmarkDao()

            val localSource = BookLocalDataSourceImpl(dao)

            val apiClient = BookApiClient()

            val remoteSource = BookRemoteDatasourceImpl(apiClient.client, BookApiMapper())

            val repository = BookRepositoryImpl(localSource, remoteSource, BookDbMapper())

            _result.value = Result.Loading
            delay(1000)
            _result.value = GetBooksUseCase(repository).getBooks(author)
        }
    }
}