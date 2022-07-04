package ru.internetcloud.bookcatalog.presentation.book_list

import androidx.recyclerview.widget.DiffUtil
import ru.internetcloud.bookcatalog.domain.model.Volume

class BookDiffCallback: DiffUtil.ItemCallback<Volume>() {
    override fun areItemsTheSame(oldItem: Volume, newItem: Volume): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Volume, newItem: Volume): Boolean {
        return oldItem == newItem
    }
}
