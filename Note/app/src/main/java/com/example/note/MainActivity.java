package com.example.note;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.ItemTouchHelper;
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
import com.example.note.persistence.NoteDataBase;
import com.example.note.persistence.NoteRepository;
import com.example.note.util.VerticalSpacingItemDecorator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NotesRecyclerAdapter.ViewHolder.OnNoteListener, View.OnClickListener {
    private static final String TAG = "MainActivity";
    //ui
    RecyclerView recyclerView;

    //var
    private ArrayList<Note> mNotes = new ArrayList<>();
    private NotesRecyclerAdapter notesRecyclerAdapter;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        initRecyclerView();
        //   fakeData();
        Toolbar toolbar = findViewById(R.id.note_toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG, "onCreate: thread" + Thread.currentThread().getName());
        setTitle("Notes");
        findViewById(R.id.fab).setOnClickListener(this);
        noteRepository = new NoteRepository(this);
        retrieveNotes();

    }



    private void retrieveNotes() {
        noteRepository.retriveNoteTask().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if (mNotes.size() > 0) {
                    mNotes.clear();
                }
                if (notes!=null) {
                    mNotes.addAll(notes);
                }
                notesRecyclerAdapter.notifyDataSetChanged();

            }
        });
    }

    //fake data for demo
    private void fakeData() {
        for (int i = 0; i < 1000; i++) {
            Note note = new Note();
            note.setTitle("title " + i);
            note.setContent("title" + i);
            note.setTimeStamp("jan 2019");
            mNotes.add(note);

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
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        //send reference and data to adapter
        notesRecyclerAdapter = new NotesRecyclerAdapter(mNotes, this);

        //setting adapter to recylerview
        recyclerView.setAdapter(notesRecyclerAdapter);

    }

    @Override
    public void onNoteClick(int position) {
        //here to write code to navigate new Activity
        Log.d(TAG, "onNoteClick: " + position);
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra("selected_note", mNotes.get(position));
        startActivity(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, NoteActivity.class);
        startActivity(intent);
    }

    private void deleteNote(Note note) {
        mNotes.remove(note);
        notesRecyclerAdapter.notifyDataSetChanged();
    }

    private ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            deleteNote(mNotes.get(viewHolder.getAdapterPosition()));

        }
    };
}
