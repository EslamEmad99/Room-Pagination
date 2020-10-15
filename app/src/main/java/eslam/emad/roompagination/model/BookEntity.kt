package eslam.emad.roompagination.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import eslam.emad.roompagination.util.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var title: String,
    var name: String
)