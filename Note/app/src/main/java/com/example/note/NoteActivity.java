package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.note.model.Note;
import com.example.note.util.LineEditText;

public class NoteActivity extends AppCompatActivity {
    private LineEditText lineEditText;
    private EditText editTitle;
    private TextView viewTitle;
    private boolean isNewNote;
    private static final String TAG = "NoteActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        lineEditText = findViewById(R.id.note_text);
        editTitle = findViewById(R.id.note_edit_title);
        viewTitle = findViewById(R.id.note_text_title);
        if (getIncomingIntent()) {
            //this is a new note (Edit mode)

        } else {
            //this is not a new note(View mode)
        }


        }

        private boolean getIncomingIntent () {
            if (getIntent().hasExtra("selected_note")) {
                Note incomingNote = getIntent().getParcelableExtra("selected_note");
                Log.d(TAG, "getIncomingIntent: " + incomingNote.toString());
                isNewNote = false;
                return false;
            }
            isNewNote = true;
            return true;
        }
    }
