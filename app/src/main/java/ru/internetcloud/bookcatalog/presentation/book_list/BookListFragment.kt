package ru.internetcloud.bookcatalog.presentation.book_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.internetcloud.bookcatalog.R
import ru.internetcloud.bookcatalog.databinding.FragmentBookListBinding
import ru.internetcloud.bookcatalog.domain.model.Result

// TODO Сделать окно поиска
// TODO Сохранить предыдущий поиск в .... и при открытии читать оттуда поиск и выводить на экран список найденного

class BookListFragment : Fragment() {

    private lateinit var bookListViewModel: BookListViewModel

    private lateinit var bookListAdapter: BookListAdapter

    private var _binding: FragmentBookListBinding? = null
    val binding: FragmentBookListBinding
        get() = _binding ?: throw IllegalStateException("FragmentBookListBinding is null")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // пока без даггера сами создадим
        bookListViewModel = ViewModelProvider(this).get(BookListViewModel::class.java)

        bookListViewModel.fetchBooks(requireActivity().application)

        setupBeerRecyclerView()
        observeBeerViewModel()
        setupClickListeners()
    }

    private fun setupBeerRecyclerView() {
        bookListAdapter = BookListAdapter()
        binding.bookRecyclerView.adapter = bookListAdapter
        // в XML  прописано app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
    }

    private fun observeBeerViewModel() {
        bookListViewModel.result.observe(viewLifecycleOwner) { currentResult ->
            Log.i("rustam", currentResult.toString())

            binding.progressBar.visibility = View.GONE
            binding.errorTextView.visibility = View.GONE
            binding.emptyTextView.visibility = View.GONE

            when (currentResult) {
                is Result.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Result.Error -> {
                    binding.errorTextView.text = getString(
                        R.string.error_message, currentResult.exception.message.toString())

                    binding.errorTextView.visibility = View.VISIBLE
                }
                is Result.Success -> {
                    if (currentResult.data.size == 0) {
                        binding.emptyTextView.visibility = View.VISIBLE
                    } else {
                        bookListAdapter.submitList(currentResult.data)
                    }
                }
            }
        }
    }

    private fun setupClickListeners() {
        //TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
