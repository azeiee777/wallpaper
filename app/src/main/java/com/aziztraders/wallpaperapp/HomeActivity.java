package com.aziztraders.wallpaperapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aziztraders.wallpaperapp.adapter.ImageRVAdapter;
import com.aziztraders.wallpaperapp.databinding.ActivityHomeBinding;
import com.aziztraders.wallpaperapp.models.WallpaperModel;
import com.aziztraders.wallpaperapp.network.MyApi;
import com.aziztraders.wallpaperapp.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding activityHomeBinding;
    RecyclerView.LayoutManager layoutManager;
    ImageRVAdapter adapter;
    List<WallpaperModel> imageData = new ArrayList<>();
    MyApi myApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        layoutManager = new GridLayoutManager(this, 3);
        activityHomeBinding.recView.setLayoutManager(layoutManager);

        fetchData();
    }

    private void fetchData() {
        activityHomeBinding.progressCircular.setVisibility(View.VISIBLE);
        myApi = RetrofitClient.getRetrofit().create(MyApi.class);
        Call<List<WallpaperModel>> call = myApi.getModels();
        call.enqueue(new Callback<List<WallpaperModel>>() {
            @Override
            public void onResponse(Call<List<WallpaperModel>> call, Response<List<WallpaperModel>> response) {
                activityHomeBinding.progressCircular.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    imageData = response.body();
                    adapter = new ImageRVAdapter(imageData,getApplicationContext());
                    activityHomeBinding.recView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<WallpaperModel>> call, Throwable t) {
                activityHomeBinding.progressCircular.setVisibility(View.GONE);
                Toast.makeText(HomeActivity.this, "Error! Can't load data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}