package com.example.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class WordAdapter extends ArrayAdapter {

        public WordAdapter(Context context, ArrayList<Word> pWords) {
            super(context,0, pWords);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            // Check if the existing view is being reused, otherwise inflate the view
            View listItemView = convertView;

            if(listItemView == null) {
                listItemView = LayoutInflater.from(getContext()).inflate(
                        R.layout.list_item, parent, false);
            }
            Word currentWord = (Word) getItem(position);
            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            miwokTextView.setText(currentWord.getMiwokTranslation());
            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            defaultTextView.setText(currentWord.getDefaultTranslation());
            ImageView imageView = listItemView.findViewById(R.id.image);
            if (currentWord.hasImage()){
                imageView.setImageResource(currentWord.getImagesourceId());

                imageView.setVisibility(View.VISIBLE);
            } else {

                imageView.setVisibility(View.GONE);

            }
            imageView.setImageResource(currentWord.getImagesourceId());

            return listItemView;
        }
    }


