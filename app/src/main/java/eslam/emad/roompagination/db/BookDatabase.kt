package eslam.emad.roompagination.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import eslam.emad.roompagination.model.BookEntity
import eslam.emad.roompagination.util.Constants.DB_NAME
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [BookEntity::class ], version = 1)
abstract class BookDatabase: RoomDatabase() {
    abstract fun bookDao(): BookDao

    companion object {
        @Volatile
        private var INSTANCE: BookDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext, BookDatabase::class.java, DB_NAME)
            .addCallback(roomCallback)
            .build()

        private val roomCallback: Callback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase()
            }
        }

        fun populateDatabase() {
            CoroutineScope(Dispatchers.IO).launch {
                repeat(300){
                    INSTANCE!!.bookDao().insertBook(BookEntity(title = "title ${it + 1}", name = "name ${it + 1}"))
                }
            }
        }
    }
}