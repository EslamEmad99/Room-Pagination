package eslam.emad.roompagination.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import eslam.emad.roompagination.db.BookDao
import eslam.emad.roompagination.db.BookDatabase
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    @Singleton
    @Provides
    fun provideBookDB(@ApplicationContext context: Context): BookDatabase {
        return BookDatabase.invoke(context)
    }

    @Singleton
    @Provides
    fun provideBookDao(bookDatabase: BookDatabase): BookDao {
        return bookDatabase.bookDao()
    }
}