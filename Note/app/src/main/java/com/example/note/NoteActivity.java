package com.example.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.note.model.Note;
import com.example.note.util.LineEditText;

public class NoteActivity extends AppCompatActivity implements View.OnTouchListener,
        GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnClickListener {
    private LineEditText lineEditText;
    private EditText editTitle;
    private TextView viewTitle;
    private boolean isNewNote;
    private Note noteInitial;
    private RelativeLayout checkContainer, backArrowContainer;
    private GestureDetector gestureDetector;
    private static final int EDIT_MODE_ENABLED = 1;
    private static final int EDIT_MODE_DISABLED = 0;
    private int mode;
    private ImageButton backImageButton, checkImageButton;


    private static final String TAG = "NoteActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        lineEditText = findViewById(R.id.note_text);
        editTitle = findViewById(R.id.note_edit_title);
        viewTitle = findViewById(R.id.note_text_title);
        backImageButton = findViewById(R.id.back_button);
        checkImageButton = findViewById(R.id.done_button);
        checkContainer = findViewById(R.id.check_container);
        backArrowContainer = findViewById(R.id.back_arrow_container);
        setListener();


        if (getIncomingIntent()) {
            //this is a new note (Edit mode)
            setNewNoteProperties();
            enableEditMode();

        } else {
            //this is not a new note(View mode)
            setNoteProperties();
        }


    }

    private void setListener() {
        gestureDetector = new GestureDetector(this, this);
        lineEditText.setOnTouchListener(this);
        viewTitle.setOnClickListener(this);
        checkImageButton.setOnClickListener(this);
    }

    private boolean getIncomingIntent() {
        if (getIntent().hasExtra("selected_note")) {
            noteInitial = getIntent().getParcelableExtra("selected_note");
            mode = EDIT_MODE_DISABLED;

            isNewNote = false;
            return false;
        }
        mode = EDIT_MODE_ENABLED;
        isNewNote = true;
        return true;
    }

    private void enableEditMode() {

        backArrowContainer.setVisibility(View.GONE);
        checkContainer.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.VISIBLE);
        viewTitle.setVisibility(View.GONE);

        mode = EDIT_MODE_ENABLED;
    }


    private void disableEditMode() {
        backArrowContainer.setVisibility(View.VISIBLE);
        editTitle.setVisibility(View.GONE);
        viewTitle.setVisibility(View.VISIBLE);
        checkContainer.setVisibility(View.GONE);
        mode = EDIT_MODE_DISABLED;


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
        enableEditMode();
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.done_button: {
                disableEditMode();
                break;
            }
            case R.id.note_text_title: {
                enableEditMode();
                editTitle.requestFocus();
                editTitle.setSelection(editTitle.length());
                break;

            }


        }

    }

    @Override
    public void onBackPressed() {
        if (mode == EDIT_MODE_ENABLED) {
            onClick(checkImageButton);
        } else {
            super.onBackPressed();
        }
    }
}

