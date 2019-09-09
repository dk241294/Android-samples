package com.example.note.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.note.R;
import com.example.note.model.Note;
import com.example.note.util.Utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NotesRecyclerAdapter.ViewHolder> {
    private static final String TAG = "NotesRecyclerAdapter";
    //datastructure to hold note object
    private ArrayList<Note> notes = new ArrayList<>();
    private ViewHolder.OnNoteListener onNoteListener;

    //default constructor
    public NotesRecyclerAdapter(ArrayList<Note> notes, ViewHolder.OnNoteListener onNoteListener) {
        this.notes = notes;
        this.onNoteListener = onNoteListener;
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
        try {
            String month = notes.get(position).getTimeStamp().substring(0, 2);
            month = Utility.getMonthFromNumber(month);
            String year = notes.get(position).getTimeStamp().substring(3);
            String timeStamp = month + " " + year;
            holder.timestamp.setText(timeStamp);
            holder.title.setText(notes.get(position).getTitle());

        } catch (NullPointerException e) {
            Log.e(TAG, "onBindViewHolder:NullPointerException " + e.getMessage());
        }
        //call for every single entery in list
        //set  the data on item


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
