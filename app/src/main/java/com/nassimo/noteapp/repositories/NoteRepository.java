package com.nassimo.noteapp.repositories;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.nassimo.noteapp.database.room.HelperInterfaceCrud;
import com.nassimo.noteapp.database.room.Note;
import com.nassimo.noteapp.database.room.NoteDao;
import com.nassimo.noteapp.database.room.NotesDB;

import java.util.List;


public class NoteRepository implements HelperInterfaceCrud {

    private NoteDao noteDao;
    private LiveData<List<Note>> listNotesLiveData;

    public NoteRepository(Application app){
        noteDao = NotesDB.getInstance(app).getNoteDao();
        listNotesLiveData = noteDao.getAllNotes();
    }

    @Override
    public void insertOrUpdateNote(Note note) {
        //You Must be use Rxjava or any Lib for Multithreading

        //Just for this moment i'm testing with class AsyncTask
        new InsertAsyncTask(noteDao).execute(note);


    }

    @Override
    public void deleteNote(Note note) {

    }

    @Override
    public void deleteAllNotes() {

    }

    @Override
    public LiveData<List<Note>> getAllNotes() {
        return listNotesLiveData;
    }


    //here i'm using AsyncTask class but it's deprecated now
    private static class InsertAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDao noteDao;
        private InsertAsyncTask(NoteDao noteDao){
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insertOrUpdateNote(notes[0]);
            return null;
        }
    }
}





