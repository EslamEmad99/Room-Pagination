package eslam.emad.roompagination.util

import androidx.recyclerview.widget.DiffUtil
import eslam.emad.roompagination.model.BookEntity

object Constants {

    const val TABLE_NAME = "books_table"

    const val DB_NAME = "books_db.db"

    val differCallback = object : DiffUtil.ItemCallback<BookEntity>() {
        override fun areItemsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BookEntity, newItem: BookEntity): Boolean {
            return oldItem == newItem
        }
    }
}