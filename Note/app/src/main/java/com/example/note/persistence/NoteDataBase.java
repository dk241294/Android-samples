package com.example.note.persistence;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.note.model.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "notes_db";
    private static NoteDataBase instance;

    static NoteDataBase getInstance(final Context context) {
        if (instance==null) {
            instance= Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,DATABASE_NAME).build();
        }
        return instance;
    }
}