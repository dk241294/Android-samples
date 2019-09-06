package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.note.model.Note;
import com.example.note.util.LineEditText;

public class NoteActivity extends AppCompatActivity  implements View.OnTouchListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private LineEditText lineEditText;
    private EditText editTitle;
    private TextView viewTitle;
    private boolean isNewNote;
    private Note noteInitial;
    private GestureDetector gestureDetector;

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
            setNewNoteProperties();

        } else {
            //this is not a new note(View mode)
            setNoteProperties();
        }
        setListener();


    }
    private void setListener(){
        lineEditText.setOnTouchListener(this);
        gestureDetector=new GestureDetector(this,this);
    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_note")) {
            noteInitial = getIntent().getParcelableExtra("selected_note");

            isNewNote = false;
            return false;
        }
        isNewNote = true;
        return true;
    }

    private void setNoteProperties() {
        viewTitle.setText(noteInitial.getTitle());
        editTitle.setText(noteInitial.getTitle());
        lineEditText.setText(noteInitial.getContent());
    }

    private void setNewNoteProperties() {
        viewTitle.setText("new note");
        editTitle.setText("new note");

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap: double tapped !");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
