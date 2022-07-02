package ru.internetcloud.bookcatalog.data.datasource

import kotlinx.coroutines.flow.Flow
import ru.internetcloud.bookcatalog.data.database.BookmarkDao
import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark

class BookLocalDataSourceImpl(
    private val bookmarkDao: BookmarkDao,
) : BookLocalDataSource {

    override suspend fun getBookmarks(): List<Bookmark> {
        return bookmarkDao.getBookmarks()
    }

    override suspend fun setBookmark(bookmark: Bookmark) {
        return bookmarkDao.setBookmark(bookmark)
    }

    override suspend fun removeBookmark(bookmark: Bookmark) {
        return bookmarkDao.removeBookmark(bookmark)
    }
}
