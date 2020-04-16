package com.example.drugbank.screens;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.drugbank.MainActivity;
import com.example.drugbank.R;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.models.Account;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Collections;
import java.util.Objects;

import static com.example.drugbank.MainActivity.accountList;
import static com.example.drugbank.components.ToastMessage.showMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvForgetPass, tvRegister;
    TextInputEditText edtUsername, edtPassword;
    Button btnLogin;
    ProgressBar idProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));// set status background white
        }
        initView();
        setClick();
    }

    private void initView() {
        idProgress = findViewById(R.id.idProgress);
        idProgress.setVisibility(View.GONE);
        tvForgetPass = findViewById(R.id.tvForgetPass);
        tvRegister = findViewById(R.id.tvRegister);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void setClick() {
        tvForgetPass.setOnClickListener(this);
        tvRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.tvForgetPass:
                break;
            case R.id.tvRegister:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
            case R.id.btnLogin:
                idProgress.setVisibility(View.VISIBLE);
                if(Objects.requireNonNull(edtUsername.getText()).toString().equals("") ||
                        Objects.requireNonNull(edtPassword.getText()).toString().equals("")) {
                    idProgress.setVisibility(View.GONE);
                    showMessage(v, getString(R.string.please_check_validate_form), Snackbar.LENGTH_SHORT);
                } else {
                    getData(v);
                }
                break;
        }
    }

    private void getData(View view) {
        APIService apiService = RetrofitClient.getInstance().create(APIService.class);
        apiService.getToken(Objects.requireNonNull(edtUsername.getText()).toString(), Objects.requireNonNull(edtPassword.getText()).toString()).enqueue(new Callback<Account>() {
            @Override
            public void onResponse(@NonNull Call<Account> call, @NonNull Response<Account> response) {
                if (!response.isSuccessful() && response.errorBody() != null) {
                    showMessage(view, getString(R.string.error) + response.errorBody().toString(), Snackbar.LENGTH_SHORT);
                } else {
                    if (response.body() != null && response.body().getStatus().equals((getString(R.string.status_true)))) {
                        accountList = Collections.singletonList(response.body());
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        showMessage(view, getString(R.string.login_success), Snackbar.LENGTH_SHORT);
                        idProgress.setVisibility(View.GONE);
                        startActivity(intent);
                        finish();
                    } else if (response.body() != null && response.body().getMessage().equals(getString(R.string.psw_fail_en))) {
                        idProgress.setVisibility(View.GONE);
                        showMessage(view, getString(R.string.pwd_fail), Snackbar.LENGTH_SHORT);
                    } else {
                        idProgress.setVisibility(View.GONE);
                        showMessage(view, getString(R.string.pwd_not_found), Snackbar.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Account> call, @NonNull Throwable t) {
                showMessage(view, getString(R.string.cant_connect_to_server), Snackbar.LENGTH_SHORT);
                idProgress.setVisibility(View.GONE);
            }
        });
    }
}
