package com.example.drugbank.fragments;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.drugbank.MainActivity;
import com.example.drugbank.R;
import com.example.drugbank.screens.EditAccountActivity;
import com.example.drugbank.screens.LoginActivity;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.drugbank.MainActivity.accountList;
import static com.example.drugbank.config.Constant.URL_REQUEST;


public class AccountFragment extends Fragment implements View.OnClickListener{
    private TextView tvFullname, tvEmail,tvPhone, tvUsername;
    private CircleImageView imgAccount;
    private RelativeLayout view_logout,view_editUser;
    public AccountFragment() {
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @SuppressLint("UnknownNullness") ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
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
        Glide.with(Objects.requireNonNull(getActivity()))
                .load(URL_REQUEST + "/uploads/" + accountList.get(0).getImage())
                .fitCenter()
                .error(R.drawable.ic_logo)
                .into(imgAccount);
    }

    private void initView(View view) {
        tvFullname = view.findViewById(R.id.tvFullname);
        tvEmail = view.findViewById(R.id.tvEmail);
        tvPhone = view.findViewById(R.id.tvPhone);
        imgAccount = view.findViewById(R.id.imgAccount);
        tvUsername = view.findViewById(R.id.tvUsername);
        view_logout = view.findViewById(R.id.view_logout);
        view_editUser = view.findViewById(R.id.view_editUser);
        view_logout.setOnClickListener(this);
        view_editUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.view_logout) {
            AlertLogin();
        } else if(v.getId() == R.id.view_editUser) {
            editUser();
        }
    }

    private void editUser() {
        startActivity(new Intent(getContext(), EditAccountActivity.class));
        Objects.requireNonNull(getActivity()).finish();
    }

    private void AlertLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("ĐĂNG XUẤT");
        builder.setMessage("Bạn có muốn đăng xuất không?");
        builder.setCancelable(false);
        builder.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(getContext(), LoginActivity.class));
                Objects.requireNonNull(getActivity()).finish();
            }
        });
        builder.setNegativeButton("Trở lại", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
