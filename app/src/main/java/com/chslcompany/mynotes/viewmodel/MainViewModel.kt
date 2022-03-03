package com.chslcompany.mynotes.viewmodel

import androidx.lifecycle.ViewModel
import com.chslcompany.mynotes.database.NoteEntity
import com.chslcompany.mynotes.repository.NoteRepositoryImpl

class MainViewModel(private val repositoryImpl : NoteRepositoryImpl) : ViewModel()  {

   fun getNotesViewModel() : List<NoteEntity>{
      return repositoryImpl.getNotesRepository()
   }
}