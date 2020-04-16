package com.example.drugbank.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.drugbank.R;
import com.example.drugbank.components.ToastMessage;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.controllers.PillAdapter;
import com.example.drugbank.models.Pill;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.drugbank.MainActivity.pillList;


public class PillFragment extends Fragment {
    private List<Pill> mPill = pillList;
    private PillAdapter pillAdapter;
    private RecyclerView rc_pill;
    public PillFragment() {
    }


    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pill, container, false);
        initView(view);
        setAdapterView(view);
//        getData(view);
        return view;
    }

 private void initView(View view) {
     rc_pill = view.findViewById(R.id.rc_pill);
     RecyclerView.LayoutManager layoutManager =
            new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
     rc_pill.setHasFixedSize(true);
     rc_pill.setLayoutManager(layoutManager);
}

    private void setAdapterView(View view) {
        pillAdapter = new PillAdapter(mPill, view.getContext());
        rc_pill.setAdapter(pillAdapter);
    }

}