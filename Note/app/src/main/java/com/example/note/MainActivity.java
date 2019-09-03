package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.note.adapter.NotesRecyclerAdapter;
import com.example.note.model.Note;
import com.example.note.util.VerticalSpacingItemDecorator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    //ui
    RecyclerView recyclerView;

    //var
    private ArrayList<Note> notes = new ArrayList<>();
    private NotesRecyclerAdapter notesRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        fakeData();
        Toolbar toolbar = findViewById(R.id.note_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Notes");

    }

    //fake data for demo
    private void fakeData() {
        for (int i = 0; i < 1000; i++) {
            Note note = new Note();
            note.setTitle("title " + i);
            note.setContent("title" + i);
            note.setTimeStamp("jan 2019");
            notes.add(note);

        }
        notesRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        //set layout manager to recyclerview
        recyclerView.setLayoutManager(linearLayoutManager);
        VerticalSpacingItemDecorator verticalSpacingItemDecorator = new VerticalSpacingItemDecorator(10);
        //set spacing to recylerview
        recyclerView.addItemDecoration(verticalSpacingItemDecorator);

        //send reference and data to adapter
        notesRecyclerAdapter = new NotesRecyclerAdapter(notes);

        //setting adapter to recylerview
        recyclerView.setAdapter(notesRecyclerAdapter);

    }
}
