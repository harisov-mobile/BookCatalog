package ru.internetcloud.bookcatalog.data.mapper

import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark
import ru.internetcloud.bookcatalog.domain.model.Book

class BookDbMapper {

    fun fromVolumeToBookmark(volume: Book): Bookmark {
        return Bookmark(
            id = volume.id
        )
    }
}
