package com.chslcompany.mynotes.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteRoomDatabase : RoomDatabase() {

    abstract fun noteDAO() : NoteDAO

    companion object {
        private const val DATABASE_NAME = "NoteRoomDatabase.db"

        @Volatile
        private var INSTANCE: NoteRoomDatabase? = null

        fun getDatabase(context: Context): NoteRoomDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    val databaseInstance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteRoomDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                    INSTANCE = databaseInstance
                    // return instance
                    databaseInstance
                }
        }
    }
}