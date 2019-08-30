package com.example.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BooksAdapter extends ArrayAdapter {
    List<Book>mbooks;

    public BooksAdapter(@NonNull Context context, int resource, @NonNull List<Book>books) {
        super(context, resource, books);
        mbooks=books;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(convertView==null){
          view=  LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }
        Book currentBook =mbooks.get(position);
        return super.getView(position, convertView, parent);
    }
}
