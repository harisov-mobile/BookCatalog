package ru.internetcloud.bookcatalog.data.repository

import ru.internetcloud.bookcatalog.data.datasource.BookLocalDataSource
import ru.internetcloud.bookcatalog.data.datasource.BookRemoteDatasource
import ru.internetcloud.bookcatalog.data.mapper.BookDbMapper
import ru.internetcloud.bookcatalog.domain.model.Book
import ru.internetcloud.bookcatalog.domain.model.Result
import ru.internetcloud.bookcatalog.domain.repository.BookRepository

class BookRepositoryImpl(
    private val localDataSource: BookLocalDataSource,
    private val remoteDataSource: BookRemoteDatasource,
    private val bookDbMapper: BookDbMapper
) : BookRepository {

    override suspend fun getBooks(author: String): Result<List<Book>> {
        // получить закладки, и выставить bookmarked
        val result = remoteDataSource.getBooks(author)
        if (result is Result.Success) {
            val bookmarks = localDataSource.getBookmarks()
            for (volume in result.data) {
                if (bookmarks.contains(bookDbMapper.fromVolumeToBookmark(volume))) {
                    volume.bookmarked = true
                }
            }
        }
        return result
    }

    override suspend fun setBookmark(volume: Book) {
        localDataSource.setBookmark(bookDbMapper.fromVolumeToBookmark(volume))
    }

    override suspend fun removeBookmark(volume: Book) {
        localDataSource.removeBookmark(bookDbMapper.fromVolumeToBookmark(volume))
    }
}
