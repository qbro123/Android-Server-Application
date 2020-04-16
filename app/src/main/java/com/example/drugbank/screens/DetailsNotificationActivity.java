package com.example.drugbank.screens;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.drugbank.MainActivity;
import com.example.drugbank.R;

import static com.example.drugbank.config.Constant.URL_REQUEST;

public class DetailsNotificationActivity extends AppCompatActivity {
    ImageView imgNews;
    TextView tvTitle, tvAuthorDate, tvNote;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_notification);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));// set status background white
        }
        initView();
        getBundle();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @SuppressLint("SetTextI18n")
    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tvTitle.setText( bundle.getString("title"));
            tvNote.setText(bundle.getString("note"));
            tvAuthorDate.setText(bundle.getString("author") +" || "+ bundle.getString("date"));
            Glide.with(this)
                    .load(URL_REQUEST+"/uploads/"+bundle.getString("image"))
                    .fitCenter()
                    .error(R.drawable.ic_logo)
                    .into(imgNews);
        }
    }

    private void initView() {
        imgNews = findViewById(R.id.imgNews);
        tvTitle = findViewById(R.id.tvTitle);
        tvAuthorDate = findViewById(R.id.tvAuthorDate);
        tvNote = findViewById(R.id.tvNote);
    }
}
