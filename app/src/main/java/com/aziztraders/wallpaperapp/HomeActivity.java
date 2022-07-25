package com.aziztraders.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.aziztraders.wallpaperapp.adapter.ImageRVAdapter;
import com.aziztraders.wallpaperapp.databinding.ActivityHomeBinding;
import com.aziztraders.wallpaperapp.models.ImageModel;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity implements ImageRVAdapter.RecyclerViewClickListener{

    ActivityHomeBinding activityHomeBinding;
    RecyclerView.LayoutManager layoutManager;
    ImageRVAdapter adapter;
    List<ImageModel> imageData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        initializeImageData();
        layoutManager = new GridLayoutManager(this,3);
        adapter = new ImageRVAdapter(imageData,getApplicationContext());
        activityHomeBinding.recView.setLayoutManager(layoutManager);
        activityHomeBinding.recView.setAdapter(adapter);
    }


    private void initializeImageData() {
        imageData = new ArrayList<>();
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));
        imageData.add(new ImageModel(R.drawable.wallpaper1));
        imageData.add(new ImageModel(R.drawable.wallpaper3));
        imageData.add(new ImageModel(R.drawable.wallpaper4));

    }

    public void openWallpaperActivity(int image){
        Intent intent = new Intent(this, WallpaperActivity.class);
        intent.putExtra("image", image);
        startActivity(intent);
    }

    @Override
    public void mClick(View v, int position) {

    }
}