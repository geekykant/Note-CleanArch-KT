package com.paavam.noteme.framework.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.paavam.core.data.Note

@Entity(tableName = "note")
data class NoteEntity (
    var title: String,
    var content: String,

    @ColumnInfo(name = "creation_date")
    var creationTime: Long,

    @ColumnInfo(name = "update_time")
    var updateTime: Long,

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,

    var priority: Int = 0,
){
    companion object{
        fun fromNote(note: Note) = NoteEntity(note.title, note.content, note.creationTime, note.updateTime, note.id, note.priority)
    }

    fun toNote() = Note(title, content, creationTime, updateTime, id, priority)
}