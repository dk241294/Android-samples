package com.example.note.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.note.model.Note;

import java.util.List;
import java.util.ListIterator;

@Dao
public interface NoteDao {
    @Insert
   long[] insertNotes(Note...notes);//...array of notes
    @Delete
    int delete(Note... note);
    @Update
    int update(Note... note);
    @Query("select *from notes ")
    LiveData<List<Note>>getNotes();


}
