package eslam.emad.roompagination.util

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import eslam.emad.roompagination.db.BookDao
import eslam.emad.roompagination.model.BookEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val bookDao: BookDao
) {
    fun getAllBooks(): LiveData<PagedList<BookEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(60)
            .setPageSize(20)
            .setPrefetchDistance(10)
            .build()

        val executor: Executor = Executors.newFixedThreadPool(5)

        return (LivePagedListBuilder(bookDao.getAllBooks(), config))
            .setFetchExecutor(executor)
            .build()
    }

}