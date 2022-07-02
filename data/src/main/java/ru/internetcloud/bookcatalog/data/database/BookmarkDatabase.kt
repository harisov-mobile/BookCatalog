package ru.internetcloud.bookcatalog.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark

@Database(entities = [Bookmark::class], version = 1, exportSchema = true)
abstract class BookmarkDatabase : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao

    companion object {

        private const val DATABASE_NAME = "bookmarks.db"

        @Volatile // чтобы данная переменная не кэшировалась!!!
        private var instance: BookmarkDatabase? = null

        private val Lock = Any()

        fun getInstance(application: Application): BookmarkDatabase {
            instance?.let {
                return it
            }
            synchronized(Lock) {
                instance?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    BookmarkDatabase::class.java,
                    DATABASE_NAME
                )
                    .build()
                instance = db
                return db
            }
        }
    }
}
