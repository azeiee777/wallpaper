package com.aziztraders.wallpaperapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aziztraders.wallpaperapp.WallpaperActivity;
import com.aziztraders.wallpaperapp.databinding.SingleItemLayoutBinding;
import com.aziztraders.wallpaperapp.models.ImageModel;

import java.util.List;


public class ImageRVAdapter extends RecyclerView.Adapter<ImageRVAdapter.MyViewHolder>{

    private List<ImageModel> data;
    private Context context;

    public ImageRVAdapter(List<ImageModel> data, Context context) {
        this.data = data;
        this.context =context;
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

        int image = data.get(position).getImg1();
        holder.singleItemLayoutBinding.img1.setImageResource(image);
        holder.singleItemLayoutBinding.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WallpaperActivity.class);
                intent.putExtra("image",image);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private SingleItemLayoutBinding singleItemLayoutBinding;

        public MyViewHolder(@NonNull SingleItemLayoutBinding singleItemLayoutBinding) {
            super(singleItemLayoutBinding.getRoot());
            this.singleItemLayoutBinding = singleItemLayoutBinding;
           // singleItemLayoutBinding.getRoot().setOnClickListener(this);
        }
    }

    public interface RecyclerViewClickListener {
        void mClick(View v, int position);
    }
}
