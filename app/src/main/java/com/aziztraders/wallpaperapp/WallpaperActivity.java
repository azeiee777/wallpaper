package com.aziztraders.wallpaperapp;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aziztraders.wallpaperapp.databinding.ActivityWallpaperBinding;

import java.io.IOException;

public class WallpaperActivity extends AppCompatActivity {

    ActivityWallpaperBinding wallpaperBinding;
    int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wallpaperBinding = DataBindingUtil.setContentView(this, R.layout.activity_wallpaper);
        Intent intent = getIntent();
        img = intent.getIntExtra("image", R.drawable.ic_launcher_background);
        wallpaperBinding.ivWallpaer.setImageResource(img);

        wallpaperBinding.btnSetWallpaper.setOnClickListener((v) -> {
            setDeviceWallpaper(img);
        });
    }

    private void setDeviceWallpaper(int img) {
        // creating the instance of the WallpaperManager
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {
            // set the wallpaper by calling the setResource function and
            // passing the drawable file
            wallpaperManager.setResource(img);
        } catch (IOException e) {
            // here the errors can be logged instead of printStackTrace
            e.printStackTrace();
        }
    }
    }