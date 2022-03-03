package com.chslcompany.mynotes.repository

import com.chslcompany.mynotes.database.NoteEntity

interface INoteRepository {

    fun getNotesRepository() : List<NoteEntity>

}
