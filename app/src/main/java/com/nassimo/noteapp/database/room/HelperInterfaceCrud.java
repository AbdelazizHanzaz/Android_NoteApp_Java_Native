package com.nassimo.noteapp.database.room;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Query;

import java.util.List;

public interface HelperInterfaceCrud {

    void insertOrUpdateNote(Note note);

    void deleteNote(Note note);

    void deleteAllNotes();

    LiveData<List<Note>> getAllNotes();
}
