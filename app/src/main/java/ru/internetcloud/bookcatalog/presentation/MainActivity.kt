package ru.internetcloud.bookcatalog.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.internetcloud.bookcatalog.R
import ru.internetcloud.bookcatalog.presentation.book_list.BookListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(R.id.fragment_container, BookListFragment())
            fragmentTransaction.commit()
        }
    }
}
