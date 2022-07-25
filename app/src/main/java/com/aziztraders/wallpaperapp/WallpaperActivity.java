package com.aziztraders.wallpaperapp;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aziztraders.wallpaperapp.databinding.ActivityWallpaperBinding;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class WallpaperActivity extends AppCompatActivity {

    ActivityWallpaperBinding wallpaperBinding;
    String imageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wallpaperBinding = DataBindingUtil.setContentView(this, R.layout.activity_wallpaper);
        Intent intent = getIntent();
        imageUrl = intent.getStringExtra("image");

        Picasso.get()
                .load(imageUrl)
                .into(wallpaperBinding.ivWallpaer);
        wallpaperBinding.btnSetWallpaper.setOnClickListener((v) -> {
            setDeviceWallpaper(imageUrl);
        });
    }

    private void setDeviceWallpaper(String url) {
        // creating the instance of the WallpaperManager
        WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

        try {

            // set the wallpaper by calling the setResource function and
            // passing the drawable file
           Bitmap image = Picasso.get()
                    .load(imageUrl).get();
            wallpaperManager.setBitmap(image);
        } catch (IOException e) {
            // here the errors can be logged instead of printStackTrace
            e.printStackTrace();
        }
    }

    }