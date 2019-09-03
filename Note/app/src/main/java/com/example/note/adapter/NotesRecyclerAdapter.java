package com.example.note.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.R;
import com.example.note.model.Note;

import java.util.ArrayList;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {
    //datastructure to hold note object
    private ArrayList<Note> notes = new ArrayList<>();
    private ViewHolder.OnNoteListener onNoteListener;

    //default constructor
    public NotesRecyclerAdapter(ArrayList<Note> notes, ViewHolder.OnNoteListener onNoteListener) {
        this.notes = notes;
        this.onNoteListener=onNoteListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method to instantiate the view holder class
        //inflate the item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list, parent, false);
        //pass view to view holder
        return new ViewHolder(view, onNoteListener);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //call for every single entery in list
        //set  the data on item
        holder.timestamp.setText(notes.get(position).getTimeStamp());
        holder.title.setText(notes.get(position).getTitle());


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
    //view holder to hold view

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, timestamp;
        //adding onNoteListener Interface to the view holder
        OnNoteListener onNoteListener;

        public ViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            //get refrence of item view
            title = itemView.findViewById(R.id.notes_title);
            timestamp = itemView.findViewById(R.id.timestamp);
            this.onNoteListener = onNoteListener;
            //attatch on click listener to entire view holder
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());

        }

        public interface OnNoteListener {
            void onNoteClick(int position);

        }
    }

}
