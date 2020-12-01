package com.paavam.noteme.framework.di

import com.paavam.noteme.framework.NoteViewModel
import com.paavam.noteme.framework.db.ListViewModel
import dagger.Component

@Component(modules = [ApplicationModule::class, RepositoryModule::class, UseCasesModule::class])
interface ViewModelComponent {
    fun inject(noteViewModel: NoteViewModel)
    fun inject(listViewModel: ListViewModel)
}