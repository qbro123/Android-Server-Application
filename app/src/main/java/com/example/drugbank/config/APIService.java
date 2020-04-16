package com.example.drugbank.config;

import androidx.annotation.NonNull;

import com.example.drugbank.models.Account;
import com.example.drugbank.models.ItemSlider;
import com.example.drugbank.models.Pill;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface APIService {
    @NonNull
    @GET("api/product/all")
    Call<List<Pill>> getProduct();

    @NonNull
    @GET("api/product/new-edit")
    Call<List<Pill>> getProductNewEdit();

    @NonNull
    @GET("api/product/pill-old")
    Call<List<Pill>> getProductOld();

    @NonNull
    @GET("api/notification")
    Call<List<ItemSlider>> getNotification();
    //http://192.168.1.2:3000/login

    @Multipart
    @POST("upload")
    Call<ResponseBody> uploadImage(
            @Part("description") RequestBody description,
            @Part MultipartBody.Part file
    );
        @NonNull
        @POST("/api/account/login")
        @FormUrlEncoded
        Call<Account> getToken(@Field("username") @NonNull String username, @Field("password") @NonNull String password);

    @NonNull
    @POST("/api/account/register")
    @FormUrlEncoded
    Call<Account> createAccount(@Field("fullname") @NonNull String fullname, @Field("username") @NonNull String username, @Field("password") @NonNull String password);

}
