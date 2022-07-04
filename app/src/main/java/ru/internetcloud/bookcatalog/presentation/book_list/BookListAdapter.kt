package ru.internetcloud.bookcatalog.presentation.book_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ru.internetcloud.bookcatalog.databinding.ItemBookListBinding
import ru.internetcloud.bookcatalog.domain.model.Volume
import ru.internetcloud.bookcatalog.presentation.util.loadImage

class BookListAdapter: ListAdapter<Volume, BookListViewHolder>(BookDiffCallback()) {

    // для отработки нажатий на элемент списка - переменная, которая будет хранить лямбда-функцию,
    // на вход лямбда-функции в качестве параметра будет передан beer: Beer,
    // лямбда-функция ничего не возвращает (то есть Unit)
    // а первоначально переменная содержит null
    var onBeerListClickListener: ((volume: Volume) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListViewHolder {
        val binding = ItemBookListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookListViewHolder, position: Int) {
        val binding = holder.binding as ItemBookListBinding

        val book = getItem(position)

        binding.titleTextView.text = book.title

        var authorsString = ""
        book.authors?.let { currentAuthors ->
            for (author in currentAuthors) {
                authorsString = authorsString + author
            }
        }

        binding.authorsTextView.text = authorsString

        book.imageUrl?.let { url ->
            binding.bookImageView.loadImage(url)
        }

        binding.publishedYearTextView.text = book.publishedYear.toString()

        binding.root.setOnClickListener {
            onBeerListClickListener?.invoke(book)
        }
    }
}