package com.example.drugbank.fragments;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drugbank.R;
import com.example.drugbank.components.ToastMessage;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RecyclerItemClickListener;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.controllers.PillAdapter;
import com.example.drugbank.models.Pill;
import com.example.drugbank.screens.DetailsPillActivity;
import com.github.ybq.android.spinkit.SpinKitView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.drugbank.MainActivity.pillList;


public class PillFragment extends Fragment implements View.OnClickListener{
    private List<Pill> mPill = pillList;
    private PillAdapter pillAdapter;
    private RecyclerView rc_pill;
    private ImageView imgReload;
    private SpinKitView spinKitView;
    private TextView tvNumPill;
    private TextInputEditText edtSearch;
    List<Pill> searchlist;
    public PillFragment() {
    }


    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pill, container, false);
        initView(view);
        setAdapterView(view);
        tvNumPill.setText("Tổng số thuốc: "+mPill.size());
        return view;
    }

 private void initView(View view) {
     edtSearch = view.findViewById(R.id.edtSearch);
     tvNumPill = view.findViewById(R.id.tvNumPill);
     rc_pill = view.findViewById(R.id.rc_pill);
     imgReload = view.findViewById(R.id.imgReload);
     spinKitView = view.findViewById(R.id.spinKitView);
     spinKitView.setVisibility(View.GONE);
     imgReload.setOnClickListener(this);
     RecyclerView.LayoutManager layoutManager =
            new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
     rc_pill.setHasFixedSize(true);
     rc_pill.setLayoutManager(layoutManager);
     edtSearch.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence s, int start, int count, int after) {

         }

         @Override
         public void onTextChanged(CharSequence s, int start, int before, int count) {
             searchlist = new ArrayList<>();
             if (s.length() == 0) {
                 searchlist = mPill;
             } else {
                 for (Pill item : mPill) {
                     if (Objects.requireNonNull(item.getTenthuoc()).toLowerCase().contains(s.toString().toLowerCase())
                             || Objects.requireNonNull(item.getDonvi()).toLowerCase().contains(s.toString().toLowerCase())) {
                         searchlist.add(item);
                     }
                 }
             }
             pillAdapter = new PillAdapter(searchlist, view.getContext());
             rc_pill.setAdapter(pillAdapter);
         }

         @Override
         public void afterTextChanged(Editable s) {
         }
     });
}

    private void setAdapterView(View view) {
        pillAdapter = new PillAdapter(mPill, view.getContext());
        rc_pill.setAdapter(pillAdapter);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imgReload) {
            spinKitView.setVisibility(View.VISIBLE);
            getData(v);
        }
    }

    public void getData(View view) {
        APIService apiService = RetrofitClient.getInstance().create(APIService.class);
        apiService.getProduct().enqueue(new Callback<List<Pill>>() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onResponse(@NonNull Call<List<Pill>> call, @NonNull Response<List<Pill>> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        pillList = response.body();
                        pillList = mPill;
                        setAdapterView(view);
                        spinKitView.setVisibility(View.GONE);
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Pill>> call, @NonNull Throwable t) {
                setAdapterView(view);
                spinKitView.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Can't connecting server, reconnecting...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}