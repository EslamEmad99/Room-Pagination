package eslam.emad.roompagination.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import eslam.emad.roompagination.R
import eslam.emad.roompagination.adapter.BookAdapter
import eslam.emad.roompagination.db.BookDao
import eslam.emad.roompagination.model.BookEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = BookAdapter()
        viewModel.bookList.observe(this, Observer {
            adapter.submitList(it)
        })
        recycler_view.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler_view.adapter = adapter
    }
}