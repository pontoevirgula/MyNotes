package com.chslcompany.mynotes.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notes: List<NoteEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteId(id : Int) : NoteEntity

    @Query("SELECT * FROM notes ORDER BY date DESC")
    fun getAll() : LiveData<List<NoteEntity>>

    @Query("DELETE FROM notes")
    fun deleteAll() : Int

    @Query("SELECT COUNT(*) FROM notes")
    fun getCount() : Int
}