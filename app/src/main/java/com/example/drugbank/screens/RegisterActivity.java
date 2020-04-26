package com.example.drugbank.screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.drugbank.R;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.models.Account;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.drugbank.components.ToastMessage.showMessage;
import static com.example.drugbank.components.ToastMessage.showMessageOption;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputEditText edtFullname, edtUsername, edtPassword, edtRePassword;
    Button btnRegister;
    ProgressBar idProgress;
    TextView tvLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(ContextCompat.getColor(getApplicationContext(),R.color.colorAccent));// set status background white
        }
        initView();
        setClick();
    }

    private void initView() {
        edtFullname = findViewById(R.id.edtFullname);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        edtRePassword = findViewById(R.id.edtRePassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLogin = findViewById(R.id.tvLogin);
        idProgress = findViewById(R.id.idProgress);
        idProgress.setVisibility(View.GONE);
    }

    private void setClick() {
        btnRegister.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void onClick(@NonNull View v) {
        switch (v.getId()) {
            case R.id.btnRegister:
                idProgress.setVisibility(View.VISIBLE);
                getData(v);
                break;
            case R.id.tvLogin:

                break;
        }
    }
    private void getData(View view) {
        APIService apiService = RetrofitClient.getInstance().create(APIService.class);
        apiService.createAccount(
               edtFullname.getText().toString(),
                edtUsername.getText().toString(),
               edtPassword.getText().toString())
                .enqueue(new Callback<Account>() {
            @SuppressLint("LogConditional")
            @Override
            public void onResponse(@NonNull Call<Account> call, @NonNull Response<Account> response) {
                if (response.body() != null) {
                    if(response.isSuccessful() && response.body().getStatus().equals("true"))  {
                        idProgress.setVisibility(View.GONE);
                        showMessageOption(view,
                                "Đăng ký thành công! Đăng nhập ngay!",
                                Snackbar.LENGTH_LONG,
                                "Đăng nhập", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                finish();
                            }
                        });
                    } else {
                        idProgress.setVisibility(View.GONE);
                        showMessageOption(view,
                                "Tài khoản đã tồn tại! Đăng nhập ngay!",
                                Snackbar.LENGTH_LONG,
                                "Đăng nhập", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                        finish();
                                    }
                                });
                    }
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                idProgress.setVisibility(View.GONE);
                showMessage(view, "Không thể kết nối tới server! Thử lại sau", Snackbar.LENGTH_SHORT);
            }
        });
    }

}

