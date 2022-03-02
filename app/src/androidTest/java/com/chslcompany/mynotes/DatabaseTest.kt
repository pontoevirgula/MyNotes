package com.chslcompany.mynotes

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.chslcompany.mynotes.database.NoteDAO
import com.chslcompany.mynotes.database.NoteRoomDatabase
import com.chslcompany.mynotes.util.NoteUtil
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private var myDB : NoteRoomDatabase? = null
    private var myDAO: NoteDAO? = null

    @Before
    fun createDB(){
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        myDB = Room.inMemoryDatabaseBuilder(context,NoteRoomDatabase::class.java).build()
        myDB?.let { myDAO = myDB!!.noteDAO() }
        Log.i(JUNIT,"Banco de dados criado")
    }

    @After
    fun closeDB(){
        myDB?.close()
    }

    @Test
    fun createAndRetrieveNotes(){
        myDAO?.insertAll(NoteUtil.getNotes())
        val count = myDAO?.getCount()
        Log.i(JUNIT,"createAndRetrieveNotes: count=$count")
        assertEquals(NoteUtil.getNotes().size,count)
    }

    companion object{
        const val JUNIT = "JUNIT"
    }
}