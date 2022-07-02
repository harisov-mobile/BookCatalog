package ru.internetcloud.bookcatalog.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark

@Dao
interface BookmarkDao {

    @Query("SELECT * FROM bookmarks")
    suspend fun getBookmarks(): List<Bookmark>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setBookmark(bookmark: Bookmark)

    @Delete
    suspend fun removeBookmark(bookmark: Bookmark)
}
