package com.chslcompany.mynotes.util

import com.chslcompany.mynotes.database.NoteEntity
import java.util.*

object NoteUtil {

    private fun getDate(diff: Int): Date {
        val cal = GregorianCalendar()
        cal.add(Calendar.MILLISECOND, diff)
        return cal.time
    }

    fun getNotes(): List<NoteEntity> {
        return listOf(
            NoteEntity(1, getDate(0), "Uma simples anotação"),
            NoteEntity(2, getDate(-1), "uma nota com um\n avanço de linha"),
            NoteEntity(3, getDate(-2), "Lorem ipsum dolor sit amet, consectetur adipiscing elit,\nsed do eiusmod tempor incididunt ut labore et " +
                    "dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea " +
                    "\ncommodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                    " Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        )
    }
}