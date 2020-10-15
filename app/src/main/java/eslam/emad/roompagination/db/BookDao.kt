package eslam.emad.roompagination.db

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import eslam.emad.roompagination.model.BookEntity
import eslam.emad.roompagination.util.Constants.TABLE_NAME

@Dao
interface BookDao {

    @Insert
    suspend fun insertBook(bookEntity: BookEntity)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllBooks(): DataSource.Factory<Int, BookEntity>
}