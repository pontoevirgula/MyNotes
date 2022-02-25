package com.chslcompany.mynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chslcompany.mynotes.databinding.NoteAdapterBinding
import com.chslcompany.mynotes.database.NoteEntity

class NoteAdapter(private val context: Context, private val notes : MutableList<NoteEntity>)
    : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private lateinit var bindingAdapter : NoteAdapterBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        bindingAdapter = NoteAdapterBinding.inflate(LayoutInflater.from(context),parent,false)
        return NoteViewHolder(bindingAdapter)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        bindingAdapter.tvNote.text = note.text
        bindingAdapter.fabAdapter.setOnClickListener {
                //TODO
        }
    }

    override fun getItemCount() = notes.size

    class NoteViewHolder(bindingAdapter: NoteAdapterBinding)
        : RecyclerView.ViewHolder(bindingAdapter.root)
}