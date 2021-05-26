package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.room.*

interface NoteDao {
    abstract fun getNotes(): LiveData<List<Note>>?
    abstract fun insertNote(note: Note)
    abstract fun deleteNote(note: Note)
    abstract fun updateNote(note: Note)
    package com.example.myapplication

    import androidx.lifecycle.LiveData
    import androidx.room.*

    @Dao
    interface NoteDao {
        @Query("Select * from note")
        fun getNotes(): LiveData<List<Note>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertNote(note: Note)

        @Delete
        suspend fun deleteNote(note: Note)

        @Update
        suspend fun updateNote(note: Note)
    }
}