package com.example.note.util;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalSpacingItemDecorator extends RecyclerView.ItemDecoration {
    private int verticalspacing;

    public VerticalSpacingItemDecorator(int verticalspacing) {
        this.verticalspacing = verticalspacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        //outrect is for spacing(rect---->rectangle)
        outRect.bottom=verticalspacing;

    }
}
