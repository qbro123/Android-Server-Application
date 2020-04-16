package com.example.drugbank.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.drugbank.R;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.drugbank.MainActivity.accountList;


public class AccountFragment extends Fragment {
    private TextView tvFullname, tvEmail,tvPhone, tvUsername;
    private CircleImageView imgView;
    public AccountFragment() {
    }


    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        initView(view);
        setTextView();
        return view;
    }

    private void setTextView() {
        tvFullname.setText(accountList.get(0).getFullname());
        tvEmail.setText(accountList.get(0).getEmail());
        tvPhone.setText(accountList.get(0).getPhone());
        tvUsername.setText(accountList.get(0).getUsername());
    }

    private void initView(View view) {
        tvFullname = view.findViewById(R.id.tvFullname);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvPhone = view.findViewById(R.id.tvPhone);
        imgView = view.findViewById(R.id.imgView);
        tvUsername = view.findViewById(R.id.tvUsername);
    }

}
