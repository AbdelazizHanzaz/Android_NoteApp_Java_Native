package com.nassimo.noteapp.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nassimo.noteapp.R;
import com.nassimo.noteapp.database.room.Note;

import java.util.List;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteViewHolder> {

     private List<Note> noteList;

     public NoteRecyclerViewAdapter(List<Note> notes){
         this.noteList = notes;
     }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_item_view,parent,false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        //holder.setTitle();
        holder.tv_title.setText(noteList.get(position).getTitle());
        holder.tv_content.setText(noteList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
         return noteList.size();
    }

    public static final class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView tv_title, tv_content;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_title =  itemView.findViewById(R.id.tv_note_title);
            tv_content = itemView.findViewById(R.id.tv_note_content);
        }



    }

}
