package com.paavam.noteme.framework.di

import android.app.Application
import com.paavam.core.repository.NoteRepository
import com.paavam.noteme.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule{

    @Provides
    fun provideRepository(app: Application) = NoteRepository(RoomNoteDataSource(app))
}