package com.example.drugbank.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.drugbank.R;
import com.example.drugbank.models.Pill;
import com.example.drugbank.screens.DetailsPillActivity;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.example.drugbank.MainActivity.pillListEdit;
import static com.example.drugbank.config.Constant.URL_REQUEST;

public class ChangePillAdapter extends RecyclerView.Adapter<ChangePillAdapter.RecyclerViewHolder> {

    private Context context;
    private List<Pill> pills = pillListEdit;
    public ChangePillAdapter(@NonNull Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ChangePillAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_menu_pill, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChangePillAdapter.RecyclerViewHolder holder, int position) {
        holder.tvCategory.setText(pills.get(position).getPhanloai());
        holder.tvNamePill.setText(pills.get(position).getTenthuoc());
        Glide.
                with(context)
                .load(URL_REQUEST+"/uploads/"+pills.get(position).getImage())
                .override(200,300)
                .fitCenter()
                .error(R.drawable.ic_logo)
                .into(holder.imgView);

    }

    @Override
    public int getItemCount() {
        return pills.size();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgView;
        TextView tvCategory, tvNamePill;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imgView);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvNamePill = itemView.findViewById(R.id.tvNamePill);
        }
    }
}
