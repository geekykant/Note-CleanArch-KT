package com.paavam.noteme.framework

import android.content.Context
import com.paavam.core.data.Note
import com.paavam.core.repository.NoteDataSource
import com.paavam.noteme.framework.db.DatabaseService
import com.paavam.noteme.framework.db.NoteEntity

class RoomNoteDataSource(context: Context) : NoteDataSource {
    val noteDao = DatabaseService.getInstance(context).notesDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))
    override suspend fun get(id: Long) = noteDao.getNoteEntity(id)?.toNote()
    override suspend fun getAll() = noteDao.getAllNoteEntities().map { it.toNote() }
    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}