package com.nassimo.noteapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.nassimo.noteapp.Utils.UtilMakeToast;
import com.nassimo.noteapp.database.room.Note;
import com.nassimo.noteapp.databinding.ActivityMainBinding;
import com.nassimo.noteapp.ui.adapter.NoteRecyclerViewAdapter;
import com.nassimo.noteapp.ui.viewModels.NoteViewModel;
import com.nassimo.noteapp.ui.viewModels.NoteViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private NoteViewModel noteViewModel;
    private NoteRecyclerViewAdapter myAdapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        noteViewModel = new NoteViewModelFactory(getApplication()).create(NoteViewModel.class);
        //LiveData.observe call onChange if data changed
        noteViewModel.getAllNotes().observe(this, notes -> {
            //update ui
            //RecyclerView....
            myAdapter = new NoteRecyclerViewAdapter(notes);
            recyclerView = binding.rvNotes;
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(myAdapter);

        });



        FloatingActionButton fab = binding.fabAddNote;
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddNoteActivity.class);
            startActivity(intent);
        });


    }



}