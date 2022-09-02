package com.nassimo.noteapp.database.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesDB extends RoomDatabase {
    private static final String DB_NAME = "Notes.db";
    private static volatile NotesDB instance;
    public abstract NoteDao getNoteDao();

    public static synchronized NotesDB getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, NotesDB.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();

        }

        return instance;
    }

    //Operation with (Deprecated Class AsyncTask) but we have RXJava do to that

    //I'm using Interface fro help me to implement this methods i needed

}
