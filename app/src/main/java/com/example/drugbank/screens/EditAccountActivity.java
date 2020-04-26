package com.example.drugbank.screens;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.drugbank.MainActivity;
import com.example.drugbank.R;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.drugbank.MainActivity.accountList;
import static com.example.drugbank.config.Constant.URL_REQUEST;

public class EditAccountActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvFullname, tvEmail, tvPhone, tvUsername,tvBack;
    Button btnChangeAccount;
    CircleImageView imgAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);
        initView();
        getValueEdit();
    }

    private void getValueEdit() {
        tvFullname.setText(accountList.get(0).getFullname());
        tvEmail.setText(accountList.get(0).getEmail());
        tvPhone.setText(accountList.get(0).getPhone());
        tvUsername.setText(accountList.get(0).getUsername());
        Glide.with(getApplicationContext())
                .load(URL_REQUEST + "/uploads/" + accountList.get(0).getImage())
                .fitCenter()
                .error(R.drawable.ic_logo)
                .into(imgAccount);
    }

    private void initView() {
        tvFullname = findViewById(R.id.tvFullname);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvUsername = findViewById(R.id.tvUsername);
        tvBack = findViewById(R.id.tvBack);
        imgAccount = findViewById(R.id.imgAccount);
        btnChangeAccount = findViewById(R.id.btnChangeAccount);
        btnChangeAccount.setOnClickListener(this);
        tvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnChangeAccount) {

        } else if(v.getId() == R.id.tvBack) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }
}
