package com.paavam.noteme.framework.db

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paavam.core.data.Note
import com.paavam.core.repository.NoteRepository
import com.paavam.core.usecase.AddNote
import com.paavam.core.usecase.GetAllNotes
import com.paavam.core.usecase.GetNote
import com.paavam.core.usecase.RemoveNote
import com.paavam.noteme.framework.RoomNoteDataSource
import com.paavam.noteme.framework.UseCases
import com.paavam.noteme.framework.di.ApplicationModule
import com.paavam.noteme.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build().inject(this)
    }

    val notes = MutableLiveData<List<Note>>()

    fun getNotes(){
        coroutineScope.launch {
            val noteList = useCases.getAllNotes()
            noteList.forEach { it.wordCount = useCases.getWordCount.invoke(it) }
            notes.postValue(noteList)
        }
    }

}