package com.aziztraders.wallpaperapp.adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aziztraders.wallpaperapp.HomeActivity;
import com.aziztraders.wallpaperapp.databinding.SingleItemLayoutBinding;
import com.aziztraders.wallpaperapp.models.ImageModel;

import java.util.List;

public class ImageRVAdapter extends RecyclerView.Adapter<ImageRVAdapter.MyViewHolder> {

    private List<ImageModel> data;

    public ImageRVAdapter(List<ImageModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        SingleItemLayoutBinding singleItemLayoutBinding = SingleItemLayoutBinding.inflate(layoutInflater, parent, false);
        return (new MyViewHolder(singleItemLayoutBinding));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.singleItemLayoutBinding.img1.setImageResource(data.get(position).getImg1());
        holder.singleItemLayoutBinding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Tag", "onClick: " + (position + 1) );
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        SingleItemLayoutBinding singleItemLayoutBinding;

        public MyViewHolder(@NonNull SingleItemLayoutBinding singleItemLayoutBinding) {
            super(singleItemLayoutBinding.getRoot());
            this.singleItemLayoutBinding = singleItemLayoutBinding;
        }
    }
}
