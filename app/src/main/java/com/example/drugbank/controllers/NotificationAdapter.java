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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drugbank.R;
import com.example.drugbank.models.ItemSlider;
import com.example.drugbank.screens.DetailsNotificationActivity;

import java.util.List;


import static com.example.drugbank.MainActivity.NOTIFICATION_LIST;
import static com.example.drugbank.config.Constant.URL_REQUEST;

public class NotificationAdapter extends  RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<ItemSlider> notificationList = NOTIFICATION_LIST;
     Context context;

    public NotificationAdapter(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifications, parent, false);
        return new NotificationAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ItemSlider ItemSlider = notificationList.get(position+5);
                holder.tvTitle.setText(ItemSlider.getTentin());
                holder.tvNote.setText(ItemSlider.getNoidung());
                Glide.with(holder.itemView)
                        .load(URL_REQUEST + "/uploads/" + ItemSlider.getHinhanh())
                        .fitCenter()
                        .error(R.drawable.ic_logo)
                        .into(holder.imgView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SyntheticAccessor")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailsNotificationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", ItemSlider.getTentin());
                bundle.putString("image", ItemSlider.getHinhanh());
                bundle.putString("note", ItemSlider.getNoidung());
                bundle.putString("date", ItemSlider.getNgaydang());
                bundle.putString("author",ItemSlider.getNguoidang());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgView;
        TextView tvTitle, tvNote;

        ViewHolder(View v) {
            super(v);
            imgView = v.findViewById(R.id.imgView);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvNote = v.findViewById(R.id.tvNote);
        }


    }
}
