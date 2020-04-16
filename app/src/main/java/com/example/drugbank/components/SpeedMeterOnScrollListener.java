package com.example.drugbank.components;

import android.widget.AbsListView;


public class SpeedMeterOnScrollListener implements AbsListView.OnScrollListener {

    private long timeStamp;
    private int lastFirstVisibleItem;

    public SpeedMeterOnScrollListener() {
        timeStamp = System.currentTimeMillis();
        lastFirstVisibleItem = 0;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        long lastTime = System.currentTimeMillis();
        //calculate speed by firstVisibleItem, lastFirstVisibleItem, timeStamp and lastTime
        timeStamp = lastTime;
        lastFirstVisibleItem = firstVisibleItem;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
}