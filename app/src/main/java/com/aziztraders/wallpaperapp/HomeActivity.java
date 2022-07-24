package com.aziztraders.wallpaperapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.aziztraders.wallpaperapp.adapter.ImageRVAdapter;
import com.aziztraders.wallpaperapp.databinding.ActivityHomeBinding;
import com.aziztraders.wallpaperapp.models.ImageModel;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

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
        adapter = new ImageRVAdapter(imageData);
        activityHomeBinding.recView.setLayoutManager(layoutManager);
        activityHomeBinding.recView.setAdapter(adapter);

    }

    private void initializeImageData() {
        imageData = new ArrayList<>();
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_foreground));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_foreground));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
        imageData.add(new ImageModel(R.drawable.ic_launcher_background));
    }
}