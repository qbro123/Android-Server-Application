package com.example.drugbank.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drugbank.R;
import com.example.drugbank.config.APIService;
import com.example.drugbank.config.RetrofitClient;
import com.example.drugbank.models.Pill;
import com.example.drugbank.screens.DetailsPillActivity;
import com.google.gson.Gson;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.drugbank.config.Constant.URL_REQUEST;

public class PillAdapter extends RecyclerView.Adapter<PillAdapter.ViewHolder>{

    List<Pill> mPill = new ArrayList<>();
    Context context;
    public PillAdapter(List<Pill> mPill, Context context) {
        this.mPill = mPill;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Collections.sort(mPill, new Comparator<Pill>() {
            @Override
            public int compare(Pill o1, Pill o2) {
                return o1.getTenthuoc().compareTo(o2.getTenthuoc());
            }
        });
        Pill pill = mPill.get(position);
        holder.getNamePill().setText(pill.getTenthuoc());
        holder.getCompany().setText(pill.getCtysx());
        Glide.
                with(context)
                .load(URL_REQUEST+"/uploads/"+pill.getImage())
                .override(200,300)
                .fitCenter()
                .error(R.drawable.ic_logo)
                .into(holder.getImagePill());
        holder.getTvView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(context.getApplicationContext(), DetailsPillActivity.class);
                String listItem = new Gson().toJson(mPill.get(position));
                bundle.putString("listItem", listItem);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.getSection().setText(pill.getTenthuoc().substring(0,1));
        if(position > 0) {
            int i = position - 1;
            if (i < mPill.size() && pill.getTenthuoc().substring(0, 1).equals(mPill.get(i).getTenthuoc().substring(0, 1))) {
                holder.getSection().setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mPill.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final LinearLayout tvView;
        private final CircleImageView imgPill;
        private final TextView tvNamePill;
        private final TextView tvCompany;
        private final TextView mSection;

        public ViewHolder (View v){
            super(v);
            tvView = v.findViewById(R.id.tvView);
            imgPill =  v.findViewById(R.id.imgPill);
            tvNamePill = v.findViewById(R.id.tvNamePill);
            tvCompany = v.findViewById(R.id.tvCompany);
            mSection = v.findViewById(R.id.mSection);
        }
        public LinearLayout getTvView() {
            return tvView;
        }
        public CircleImageView getImagePill() {
            return imgPill;
        }

        public TextView getNamePill() {
            return tvNamePill;
        }

        public TextView getCompany() {
            return tvCompany;
        }

        public TextView getSection() {
            return mSection;
        }
    }
}