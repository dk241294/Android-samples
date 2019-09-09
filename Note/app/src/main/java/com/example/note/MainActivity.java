package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.note.adapter.NotesRecyclerAdapter;
import com.example.note.model.Note;
import com.example.note.util.VerticalSpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NotesRecyclerAdapter.ViewHolder.OnNoteListener, View.OnClickListener {
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
        findViewById(R.id.fab).setOnClickListener(this);

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
        notesRecyclerAdapter = new NotesRecyclerAdapter(notes,this);

        //setting adapter to recylerview
        recyclerView.setAdapter(notesRecyclerAdapter);

    }

    @Override
    public void onNoteClick(int position) {
        //here to write code to navigate new Activity
        Log.d(TAG, "onNoteClick: "+position);
        Intent intent =new Intent(this,NoteActivity.class);
        intent.putExtra("selected_note", notes.get(position));
        startActivity(intent );

    }

    @Override
    public void onClick(View v) {
Intent intent=new Intent(this,NoteActivity.class);
startActivity(intent);
    }
}
