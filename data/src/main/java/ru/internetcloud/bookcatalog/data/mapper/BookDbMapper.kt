package ru.internetcloud.bookcatalog.data.mapper

import ru.internetcloud.bookcatalog.data.dbmodel.Bookmark
import ru.internetcloud.bookcatalog.domain.model.Volume

class BookDbMapper {

    fun fromVolumeToBookmark(volume: Volume): Bookmark {
        return Bookmark(
            id = volume.id
        )
    }
}
