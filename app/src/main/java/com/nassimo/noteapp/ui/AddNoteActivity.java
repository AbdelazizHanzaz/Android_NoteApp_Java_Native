package com.nassimo.noteapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nassimo.noteapp.R;
import com.nassimo.noteapp.Utils.UtilMakeToast;
import com.nassimo.noteapp.database.room.Note;
import com.nassimo.noteapp.ui.viewModels.NoteViewModel;
import com.nassimo.noteapp.ui.viewModels.NoteViewModelFactory;

public class AddNoteActivity extends AppCompatActivity implements View.OnClickListener {

    private NoteViewModel noteViewModel;
    private EditText editTextTitle, editTextContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        //add notes
        init();

        //LiveData.observe call onChange if data changed
        noteViewModel.getAllNotes().observe(this, notes -> {
            //update ui
            //RecyclerView....
            StringBuilder stringBuilder = new StringBuilder();
            for(Note note : notes){
                stringBuilder.append(note.getNoteID()+"\t");
            }
            UtilMakeToast.shortToast(this,"Items Count : "+notes.size());
        });
    }

    private void init(){
        Button btn_add_note = findViewById(R.id.btn_add_note);
        Button btn_scrolling_activity = findViewById(R.id.btn_scrollingActivity);
        editTextTitle = findViewById(R.id.editText_title);
        editTextContent = findViewById(R.id.editText_content);
        btn_add_note.setOnClickListener(this);
        btn_scrolling_activity.setOnClickListener(this);
        //init viewModel
        noteViewModel = new NoteViewModelFactory(getApplication()).create(NoteViewModel.class);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_add_note){
            String title = editTextTitle.getText().toString();
            String content = editTextContent.getText().toString();
            noteViewModel.insertOrUpdateNote(new Note(title, content));
        }
        if(view.getId() == R.id.btn_scrollingActivity){
            Intent intent = new Intent(this, ScrollingActivity.class);
            startActivity(intent);
        }


    }
}