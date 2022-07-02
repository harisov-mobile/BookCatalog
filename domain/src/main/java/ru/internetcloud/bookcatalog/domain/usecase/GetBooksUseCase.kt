package ru.internetcloud.bookcatalog.domain.usecase

import ru.internetcloud.bookcatalog.domain.repository.BookRepository

class GetBooksUseCase(private val bookRepository: BookRepository) {

    suspend fun getBooks(author: String) = bookRepository.getBooks(author)
}
