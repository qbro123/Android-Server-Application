package com.example.drugbank.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.drugbank.R;

public class DetailsPillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pill);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
