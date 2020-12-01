package com.paavam.noteme.framework.di

import com.paavam.core.repository.NoteRepository
import com.paavam.core.usecase.*
import com.paavam.noteme.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository),
        GetWordCount()
    )
}