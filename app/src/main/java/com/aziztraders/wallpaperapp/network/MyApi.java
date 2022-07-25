package com.aziztraders.wallpaperapp.network;

import com.aziztraders.wallpaperapp.models.WallpaperModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {

    @GET("photos")
    Call<List<WallpaperModel>> getModels();
}
