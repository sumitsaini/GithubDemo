package com.github.carrerfour.Repo.Services;

import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.model.ProfileRepo;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by sumitsaini on 17/06/2019 AD.
 */

public interface CommonApi {

    @GET("/users/{userName}")
    Call<ProfileDetail> getDetail(@Path("userName") String userName);

    @GET("/users/{userName}/repos")
    Call<ArrayList<ProfileRepo>> getRepos(@Path("userName") String userName);


}
