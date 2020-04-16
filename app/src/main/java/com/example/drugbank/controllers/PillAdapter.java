package com.example.drugbank.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.drugbank.R;
import com.example.drugbank.models.Pill;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

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

        private final CircleImageView imgPill;
        private final TextView tvNamePill;
        private final TextView tvCompany;
        private final TextView mSection;

        public ViewHolder (View v){
            super(v);
            imgPill =  v.findViewById(R.id.imgPill);
            tvNamePill = v.findViewById(R.id.tvNamePill);
            tvCompany = v.findViewById(R.id.tvCompany);
            mSection = v.findViewById(R.id.mSection);
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