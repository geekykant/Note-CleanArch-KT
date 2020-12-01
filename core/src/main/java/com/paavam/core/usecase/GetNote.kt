package com.paavam.core.usecase

import com.paavam.core.data.Note
import com.paavam.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {
    suspend operator fun invoke(id: Long) = noteRepository.getNote(id)
}