package com.paavam.noteme.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.ColorFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.paavam.core.data.Note
import com.paavam.noteme.R
import kotlinx.android.synthetic.main.item_note.view.*
import java.text.SimpleDateFormat
import java.util.*

class NotesListAdapter(var notes: ArrayList<Note>, val actions: ListAction) :
    RecyclerView.Adapter<NotesListAdapter.NoteViewHolder>() {

    fun updateNotes(newNotes: List<Note>){
        notes.clear()
        notes.addAll(newNotes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_note, parent, false
        )
    )

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount() = notes.size

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val layout = view.noteLayout
        private val noteTitle = view.title
        private val noteContent = view.content
        private val noteDate = view.date
        private val noteWords = view.wordCount
        private val notePriority = view.priority

        fun bind(note: Note) {
            noteTitle.text = note.title
            noteContent.text = note.content

            val sdf = SimpleDateFormat("MMM dd, HH:mm")
            val resultDate = Date(note.updateTime)
            noteDate.text = "Updated: ${sdf.format(resultDate)}"

            layout.setOnClickListener {
                actions.onClick(note.id)
            }

            noteWords.text = "Words: ${note.wordCount}"
            when(note.priority){
                0 -> notePriority.setTint(notePriority.context, R.color.low_priority)
                1 -> notePriority.setTint(notePriority.context, R.color.medium_priority)
                2 -> notePriority.setTint(notePriority.context, R.color.high_priority)
            }
        }

        private fun ImageView.setTint(context: Context, @ColorRes colorId: Int) {
            val color = ContextCompat.getColor(context, colorId)
            val colorStateList = ColorStateList.valueOf(color)
            ImageViewCompat.setImageTintList(this, colorStateList)
        }
    }

}