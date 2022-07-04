package ru.internetcloud.bookcatalog.presentation.book_list

import androidx.recyclerview.widget.DiffUtil
import ru.internetcloud.bookcatalog.domain.model.Book

class BookDiffCallback : DiffUtil.ItemCallback<Book>() {
    override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
        return oldItem == newItem
    }
}
