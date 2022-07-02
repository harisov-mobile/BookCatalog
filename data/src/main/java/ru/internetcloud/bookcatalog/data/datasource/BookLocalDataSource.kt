package ru.internetcloud.bookcatalog.data.datasource

import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark

interface BookLocalDataSource {

    suspend fun getBookmarks(): List<Bookmark>

    suspend fun setBookmark(bookmark: Bookmark)

    suspend fun removeBookmark(bookmark: Bookmark)
}
