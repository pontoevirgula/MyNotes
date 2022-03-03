package com.chslcompany.mynotes.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chslcompany.mynotes.repository.NoteRepositoryImpl
import com.chslcompany.mynotes.viewmodel.MainViewModel

class ViewModelFactory(private val repositoryImpl : NoteRepositoryImpl)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repositoryImpl) as T
    }

}

