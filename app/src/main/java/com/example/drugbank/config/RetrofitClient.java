package com.example.drugbank.config;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.drugbank.config.Constant.URL_REQUEST;

public class RetrofitClient {
    @SuppressLint("UnknownNullness")
    private static Retrofit retrofit;

    @NonNull
    public static Retrofit getInstance() {
    if(retrofit == null) {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL_REQUEST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    return retrofit;
}
}
