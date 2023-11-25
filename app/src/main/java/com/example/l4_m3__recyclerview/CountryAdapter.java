package com.example.l4_m3__recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<ViewHolder> {
    private ArrayList<CountryModel> countryList;
    private OnClick onClick;

    public CountryAdapter(ArrayList<CountryModel> countryList, OnClick onClick) {
        this.countryList = countryList;
        this.onClick = onClick;
    }

    public CountryAdapter(ArrayList<CountryModel> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(countryList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        onClick.onClick(holder.getAdapterPosition());
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size() ;
    }
}

// ViewHolder********************************************************

class ViewHolder extends RecyclerView.ViewHolder{
    private TextView tvName,tvCapital;
    private ImageView imgFlag;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        tvName=itemView.findViewById(R.id.tv_name);
        tvCapital=itemView.findViewById(R.id.tv_capital);
        imgFlag=itemView.findViewById(R.id.img_flag);
    }
    public void bind(CountryModel country){
    tvName.setText(country.getName());
    tvCapital.setText(country.getCapital());
        Glide.with(imgFlag).load(country.getFlag()).into(imgFlag);

    }
}
