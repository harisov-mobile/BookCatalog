package ru.internetcloud.bookcatalog.data.mapper

import ru.internetcloud.bookcatalog.data.network.dto.BookItemDTO
import ru.internetcloud.bookcatalog.domain.model.Book

class BookApiMapper {

    fun fromListDTOToListEntity(listBookItemDTO: List<BookItemDTO>): List<Book> {
        return listBookItemDTO.map { fromDTOToEntity(it) }
    }

    private fun fromDTOToEntity(bookItemDTO: BookItemDTO): Book {
        return Book(
            id = bookItemDTO.id,
            title = bookItemDTO.volumeInfo.title,
            authors = bookItemDTO.volumeInfo.authors,
            imageUrl = bookItemDTO.volumeInfo.imageLinks?.thumbnail?.replace("http://", "https://"),
            publishedYear = bookItemDTO.volumeInfo.publishedDate.substring(startIndex = 0, endIndex = 4).toInt(),
            bookmarked = false
        )
    }
}
