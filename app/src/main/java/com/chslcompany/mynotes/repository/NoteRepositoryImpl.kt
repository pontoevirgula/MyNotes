package com.chslcompany.mynotes.repository

import com.chslcompany.mynotes.util.NoteUtil

class NoteRepositoryImpl : INoteRepository{

    override fun getNotesRepository() = NoteUtil.getNotes()

}
