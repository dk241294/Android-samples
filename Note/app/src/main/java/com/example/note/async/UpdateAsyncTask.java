package com.example.note.async;

import android.os.AsyncTask;
import android.util.Log;

import com.example.note.model.Note;
import com.example.note.persistence.NoteDao;

public class UpdateAsyncTask extends AsyncTask<Note,Void,Void> {
    private static final String TAG = "UpdateAsyncTask";
    private NoteDao noteDao;

    public UpdateAsyncTask(NoteDao dao) {
        noteDao=dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        Log.d(TAG, "doInBackground: thread "+Thread.currentThread().getName());
        noteDao.updateNotes(notes);
        return null;
    }
}
