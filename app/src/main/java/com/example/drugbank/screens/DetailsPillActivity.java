package com.example.drugbank.screens;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drugbank.R;
import com.example.drugbank.models.Pill;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import static com.example.drugbank.MainActivity.pillListEdit;


public class DetailsPillActivity extends AppCompatActivity implements View.OnClickListener {
     TextView tvNamePill,tvCategoryPill,tvNumberPill,tvNamePill2,tvCategoryPill2,tvHL,
            tvTT,tvDBC, tvQCDG, tvCtySX, tvCtyDK, tvTCC, tvDVKK, tvDateKK, tvPricePill, tvDVT;
    ImageView imgBack,imgFavorite;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_pill);
        initView();
        getBundle();
    }

    private void initView() {
        tvNamePill = findViewById(R.id.tvNamePill);
        tvDVT = findViewById(R.id.tvDVT);
        tvPricePill = findViewById(R.id.tvPricePill);
        tvDateKK = findViewById(R.id.tvDateKK);
        tvDVKK = findViewById(R.id.tvDVKK);
        tvTCC = findViewById(R.id.tvTCC);
        tvCategoryPill = findViewById(R.id.tvCategoryPill);
        tvNumberPill = findViewById(R.id.tvNumberPill);
        tvNamePill2 = findViewById(R.id.tvNamePill2);
        tvCategoryPill2 = findViewById(R.id.tvCategoryPill2);
        tvHL = findViewById(R.id.tvHL);
        tvTT = findViewById(R.id.tvTT);
        tvDBC = findViewById(R.id.tvDBC);
        tvQCDG = findViewById(R.id.tvQCDG);
        tvCtySX = findViewById(R.id.tvCtySX);
        tvCtyDK = findViewById(R.id.tvCtyDK);
        imgBack = findViewById(R.id.imgBack);
        imgBack.setOnClickListener(this);
        imgFavorite = findViewById(R.id.imgFavorite);
    }

    @SuppressLint("LogConditional")
    private void getBundle() {
        Bundle b = getIntent().getExtras();
        if (b != null) {
            String a = b.getString("listJson");
            if(a != null) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<Pill>>(){}.getType();
                List<Pill> pillList = gson.fromJson(a, type);
                for (Pill pill : pillList){
                    tvNamePill.setText(pill.getTenthuoc());
                    tvCategoryPill.setText(pill.getPhanloai());
                    tvNumberPill.setText(pill.getSodangky());
                    tvNamePill2.setText(pill.getTenthuoc());
                    tvCategoryPill2.setText(pill.getPhanloai());
                    tvHL.setText(pill.getHoatchat());
                    tvTT.setText(pill.getTuoitho());
                    tvDBC.setText(pill.getDangbaoche());
                    tvQCDG.setText(pill.getQuycach());
                    tvCtySX.setText(pill.getCtysx());
                    tvCtyDK.setText(pill.getCtydk());
                    tvTCC.setText(pill.getTieuchuan());
                    tvDVKK.setText(pill.getDonvi());
                    tvDateKK.setText(pill.getNgaykekhai());
                    tvPricePill.setText(pill.getGiakekhai());
                    tvDVT.setText(pill.getDvt());
                }
            } else {
                int position = b.getInt("position");
                tvNamePill.setText(pillListEdit.get(position).getTenthuoc());
                tvCategoryPill.setText(pillListEdit.get(position).getPhanloai());
                tvNumberPill.setText(pillListEdit.get(position).getSodangky());
                tvNamePill2.setText(pillListEdit.get(position).getTenthuoc());
                tvCategoryPill2.setText(pillListEdit.get(position).getPhanloai());
                tvHL.setText(pillListEdit.get(position).getHoatchat());
                tvTT.setText(pillListEdit.get(position).getTuoitho());
                tvDBC.setText(pillListEdit.get(position).getDangbaoche());
                tvQCDG.setText(pillListEdit.get(position).getQuycach());
                tvCtySX.setText(pillListEdit.get(position).getCtysx());
                tvCtyDK.setText(pillListEdit.get(position).getCtydk());
                tvTCC.setText(pillListEdit.get(position).getTieuchuan());
                tvDVKK.setText(pillListEdit.get(position).getDonvi());
                tvDateKK.setText(pillListEdit.get(position).getNgaykekhai());
                tvPricePill.setText(pillListEdit.get(position).getGiakekhai());
                tvDVT.setText(pillListEdit.get(position).getDvt());
            }
        }
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onClick(@Nullable View v) {
        if(v.getId() == R.id.imgBack) {
            finish();
        }
    }
}
