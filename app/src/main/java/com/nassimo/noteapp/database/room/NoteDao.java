package com.nassimo.noteapp.database.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdateNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Query("DELETE FROM Note")
    void deleteAllNotes();

    @Query("SELECT * FROM Note")
    LiveData<List<Note>> getAllNotes();
}
