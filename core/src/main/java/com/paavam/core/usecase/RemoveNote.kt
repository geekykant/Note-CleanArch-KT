package com.paavam.core.usecase

import com.paavam.core.data.Note
import com.paavam.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(note: Note) = noteRepository.removeNote(note)
}