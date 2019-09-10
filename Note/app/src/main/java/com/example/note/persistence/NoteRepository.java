package com.example.note.persistence;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;

import com.example.note.async.DeleteAsyncTask;
import com.example.note.async.InsertAsyncTask;
import com.example.note.async.UpdateAsyncTask;
import com.example.note.model.Note;

import java.util.List;

public class NoteRepository {
    private NoteDataBase noteDataBase;

    public NoteRepository(Context context) {

        noteDataBase = NoteDataBase.getInstance(context);


    }

    public void insertNoteTask(Note note) {
        new InsertAsyncTask(noteDataBase.getNoteDao()).execute(note);
    }

    public void updateNoteTask(Note note) {
        new UpdateAsyncTask(noteDataBase.getNoteDao()).execute(note);
    }

    public LiveData<List<Note>> retriveNoteTask() {
        return noteDataBase.getNoteDao().getNotes();
    }

    public void deleteNote(Note note) {
        new DeleteAsyncTask(noteDataBase.getNoteDao()).execute(note);
    }
}
