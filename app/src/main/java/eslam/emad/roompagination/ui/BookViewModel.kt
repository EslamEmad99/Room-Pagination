package eslam.emad.roompagination.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import eslam.emad.roompagination.model.BookEntity
import eslam.emad.roompagination.util.Repository

class BookViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel(), LifecycleObserver {
    var bookList: LiveData<PagedList<BookEntity>> = repository.getAllBooks()
}