package com.example.drugbank.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.example.drugbank.R;
import com.example.drugbank.models.ItemSlider;
import com.example.drugbank.screens.DetailsNotificationActivity;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import static com.example.drugbank.MainActivity.NOTIFICATION_LIST;
import static com.example.drugbank.config.Constant.URL_REQUEST;


public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

    private Context context;
    @NonNull
    private List<ItemSlider> mSliderItems = NOTIFICATION_LIST;

    public SliderAdapter(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public SliderAdapterVH onCreateViewHolder(@NonNull ViewGroup parent) {
        @SuppressLint("InflateParams") View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slider, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SliderAdapterVH viewHolder, final int position) {

        ItemSlider sliderItem = mSliderItems.get(position);
        viewHolder.tvTitle.setText(sliderItem.getTentin());
        Glide.with(viewHolder.itemView)
                .load(URL_REQUEST+"/uploads/"+sliderItem.getHinhanh())
                .fitCenter()
                .error(R.drawable.ic_logo)
                .into(viewHolder.imgNotification);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsNotificationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", sliderItem.getTentin());
                bundle.putString("image", sliderItem.getHinhanh());
                bundle.putString("note", sliderItem.getNoidung());
                bundle.putString("date", sliderItem.getNgaydang());
                bundle.putString("author",sliderItem.getNguoidang());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getCount() {
        return 5;
    }

    static class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        ImageView imgNotification;
        TextView tvTitle;
        View itemView;

        SliderAdapterVH(View itemView) {
            super(itemView);
            imgNotification = itemView.findViewById(R.id.imgNotification);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            this.itemView = itemView;

        }
    }

}