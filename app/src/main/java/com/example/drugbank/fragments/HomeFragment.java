package com.example.drugbank.fragments;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.drugbank.R;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RecyclerItemClickListener;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.controllers.ChangePillAdapter;
import com.example.drugbank.controllers.NewPillAdapter;
import com.example.drugbank.controllers.NotificationAdapter;
import com.example.drugbank.controllers.SliderAdapter;
import com.example.drugbank.models.ItemSlider;
import com.example.drugbank.models.Pill;
import com.example.drugbank.screens.DetailsPillActivity;
import com.github.ybq.android.spinkit.SpinKitView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.drugbank.MainActivity.pillList;
import static com.example.drugbank.MainActivity.NOTIFICATION_LIST;
import static com.example.drugbank.MainActivity.pillListEdit;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private SliderView imageSlider;
    RecyclerView idNewPill, idNewEditPill,idPillOut, rc_notifications;
    APIService apiService;
    SpinKitView spinKitView,spinKitView2, spinKitView1,spinKitView4;
    RecyclerView.LayoutManager layoutManager1, layoutManager2, layoutManager3, layoutManager4;
    LinearLayoutManager HorizontalLayout, HorizontalLayout2, HorizontalLayout3, HorizontalLayout4;


    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        getData();
        spinKitView2.setVisibility(View.VISIBLE);
        spinKitView.setVisibility(View.VISIBLE);
        spinKitView1.setVisibility(View.VISIBLE);
        spinKitView4.setVisibility(View.VISIBLE);
    }

    private void setAdapter1() {
        NewPillAdapter newPillAdapter = new NewPillAdapter(getContext());
        layoutManager1 = new LinearLayoutManager(getContext());
        HorizontalLayout  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        idNewPill.setLayoutManager(layoutManager1);
        idNewPill.setLayoutManager(HorizontalLayout);
        idNewPill.setAdapter(newPillAdapter);
        idNewPill.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), idNewPill, new RecyclerItemClickListener.OnItemClickListener() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onItemClick(@Nullable View view, int position) {
                getPositionAndIntent(position);
            }
            @Override
            public void onLongItemClick(@Nullable View view, int position) {

            }
        }));
    }
    private void setAdapter2() {
        ChangePillAdapter changePillAdapter = new ChangePillAdapter(getContext());
        layoutManager1 = new LinearLayoutManager(getContext());
        HorizontalLayout2  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        idNewEditPill.setLayoutManager(layoutManager2);
        idNewEditPill.setLayoutManager(HorizontalLayout2);
        idNewEditPill.setAdapter(changePillAdapter);
        idNewEditPill.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), idNewEditPill, new RecyclerItemClickListener.OnItemClickListener() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onItemClick(@Nullable View view, int position) {
                getPositionAndIntent(position);
            }

            @Override
            public void onLongItemClick(@Nullable View view, int position) {

            }
        }));
    }
    private void setAdapter3() {
        ChangePillAdapter changePillAdapter = new ChangePillAdapter(getContext());
        layoutManager3 = new LinearLayoutManager(getContext());
        HorizontalLayout3  = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        idPillOut.setLayoutManager(layoutManager2);
        idPillOut.setLayoutManager(HorizontalLayout3);
        idPillOut.setAdapter(changePillAdapter);
        idPillOut.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), idPillOut, new RecyclerItemClickListener.OnItemClickListener() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onItemClick(@Nullable View view, int position) {
                getPositionAndIntent(position);
            }

            @Override
            public void onLongItemClick(@Nullable View view, int position) {

            }
        }));
    }
    private void setAdapter4() {
        NotificationAdapter notificationAdapter = new NotificationAdapter(getContext());
        layoutManager4 = new LinearLayoutManager(getContext());
        HorizontalLayout4  = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rc_notifications.setLayoutManager(layoutManager4);
        rc_notifications.setLayoutManager(HorizontalLayout4);
        rc_notifications.setAdapter(notificationAdapter);
    }


    private void getData() {
            apiService = RetrofitClient.getInstance().create(APIService.class);
            apiService.getNotification().enqueue(new Callback<List<ItemSlider>>() {
                @SuppressLint("SyntheticAccessor")
                @Override
                public void onResponse(@NonNull Call<List<ItemSlider>> call, @NonNull Response<List<ItemSlider>> response) {
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            NOTIFICATION_LIST = response.body();
                            setAdapterSlider();
                            setAdapter4();
                            spinKitView4.setVisibility(View.GONE);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<ItemSlider>> call, Throwable t) {

                }
            });
            apiService.getProductNewEdit().enqueue(new Callback<List<Pill>>() {
                @SuppressLint("SyntheticAccessor")
                @Override
                public void onResponse(Call<List<Pill>> call, Response<List<Pill>> response) {
                    if(response.isSuccessful()) {
                        if(response.body() != null) {
                            pillListEdit = response.body();
                            setAdapter2();
                            setAdapter3();
                            spinKitView1.setVisibility(View.GONE);
                            spinKitView2.setVisibility(View.GONE);
                        }
                    }
                }

                @Override
                public void onFailure(Call<List<Pill>> call, Throwable t) {
                    Toast.makeText(getContext(), "Can't connecting server, reconnecting...", Toast.LENGTH_SHORT).show();
                }
            });
            apiService.getProduct().enqueue(new Callback<List<Pill>>() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onResponse(@NonNull Call<List<Pill>> call, @NonNull Response<List<Pill>> response) {
                if(response.isSuccessful()) {
                    if (response.body() != null) {
                        pillList = response.body();
                        setAdapter1();
                        spinKitView.setVisibility(View.GONE);

                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<List<Pill>> call, @NonNull Throwable t) {
                Toast.makeText(getContext(), "Can't connecting server, reconnecting...", Toast.LENGTH_SHORT).show();
            }

        });
        }
    private void setAdapterSlider() {
        SliderAdapter sliderAdapter = new SliderAdapter(getContext());
        imageSlider.setSliderAdapter(sliderAdapter);
        imageSlider.setIndicatorAnimation(IndicatorAnimations.THIN_WORM);
        imageSlider.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        imageSlider.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        imageSlider.setIndicatorSelectedColor(Color.WHITE);
        imageSlider.setIndicatorUnselectedColor(Color.GRAY);
        imageSlider.setScrollTimeInSec(3);
        imageSlider.setAutoCycle(false);
    }

    private void initView(View view) {
        imageSlider = view.findViewById(R.id.imageSlider);
        idNewPill = view.findViewById(R.id.idNewPill);
        idNewEditPill = view.findViewById(R.id.idNewEditPill);
        idPillOut = view.findViewById(R.id.idPillOut);
        spinKitView = view.findViewById(R.id.spinKitView);
        spinKitView2 = view.findViewById(R.id.spinKitView2);
        spinKitView1 = view.findViewById(R.id.spinKitView1);
        spinKitView4 = view.findViewById(R.id.spinKitView4);
        rc_notifications = view.findViewById(R.id.rc_notifications);
    }

    @Override
    public void onClick(@Nullable View v) {

    }
    private void getPositionAndIntent(int position) {
        Intent intent = new Intent(getContext(), DetailsPillActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
