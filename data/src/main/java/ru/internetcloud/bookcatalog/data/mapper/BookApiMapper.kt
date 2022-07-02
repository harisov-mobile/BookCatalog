package ru.internetcloud.bookcatalog.data.mapper

import ru.internetcloud.bookcatalog.data.network.dto.BookItemDTO
import ru.internetcloud.bookcatalog.domain.model.Volume

class BookApiMapper {

    fun fromListDTOToListEntity(listBookItemDTO: List<BookItemDTO>): List<Volume> {
        return listBookItemDTO.map { fromDTOToEntity(it) }
    }

    private fun fromDTOToEntity(bookItemDTO: BookItemDTO): Volume {
        return Volume(
            id = bookItemDTO.id,
            title = bookItemDTO.volumeInfo.title,
            authors = bookItemDTO.volumeInfo.authors,
            imageUrl = bookItemDTO.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://"),
            publishedYear = bookItemDTO.volumeInfo.publishedDate.substring(startIndex = 0, endIndex = 3).toInt(),
            bookmarked = false
        )
    }
}
