package com.nassimo.noteapp.ui.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nassimo.noteapp.database.room.HelperInterfaceCrud;
import com.nassimo.noteapp.database.room.Note;
import com.nassimo.noteapp.repositories.NoteRepository;

import java.util.List;

import io.reactivex.Completable;

public class NoteViewModel extends ViewModel implements HelperInterfaceCrud {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> notes;

    public NoteViewModel(@NonNull Application app){
        noteRepository = new NoteRepository(app);
        notes  = noteRepository.getAllNotes();
    }

    @Override
    public void insertOrUpdateNote(Note note) {
          noteRepository.insertOrUpdateNote(note);
    }

    @Override
    public void deleteNote(Note note) {

    }

    @Override
    public void deleteAllNotes() {

    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return notes;
    }


    //This operation to get data from repository

}
