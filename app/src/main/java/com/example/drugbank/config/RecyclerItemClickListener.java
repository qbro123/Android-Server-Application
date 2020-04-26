package com.example.drugbank.config;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        public void onItemClick(@Nullable View view, int position);

        public void onLongItemClick(@Nullable View view, int position);
    }
    private GestureDetector mGestureDetector;

    public RecyclerItemClickListener(@Nullable Context context, final @Nullable RecyclerView recyclerView, @Nullable OnItemClickListener listener) {
        mListener = listener;
        mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onLongPress(MotionEvent e) {
                View child = null;
                if (recyclerView != null) {
                    child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && mListener != null) {
                        mListener.onLongItemClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            }
        });
    }

    @Override public boolean onInterceptTouchEvent(@Nullable RecyclerView view, @NonNull MotionEvent e) {

        if (view != null) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
                return true;
            }
        }
        return false;
    }

    @Override public void onTouchEvent(@Nullable RecyclerView view, @Nullable MotionEvent motionEvent) { }

    @Override
    public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}
}