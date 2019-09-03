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

    //default constructor
    public NotesRecyclerAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method to instantiate the view holder class
        //inflate the item layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list, parent, false);
       //pass view to view holder
        return new ViewHolder(view);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, timestamp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //get refrence of item view
            title = itemView.findViewById(R.id.notes_title);
            timestamp = itemView.findViewById(R.id.timestamp);
        }
    }

}
