package com.github.carrerfour.Repo;

import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.Repo.Services.CommonApi;
import com.github.carrerfour.Repo.Services.RetrofitService;
import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.model.ProfileRepo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private CommonApi commonApi;
    private final String TAG = NewsRepository.class.getSimpleName();

    public NewsRepository() {
        commonApi = RetrofitService.getInstance().create(CommonApi.class);
    }

    public MutableLiveData<ProfileDetail> getDetails(String userName) {

        final MutableLiveData<ProfileDetail> responseContainerMutableLiveData = new MutableLiveData<ProfileDetail>();

        commonApi.getDetail(userName).enqueue(new Callback<ProfileDetail>() {
            @Override
            public void onResponse(Call<ProfileDetail> call, Response<ProfileDetail> response) {
                responseContainerMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ProfileDetail> call, Throwable t) {
                responseContainerMutableLiveData.postValue(null);
            }
        });

        return responseContainerMutableLiveData;


    }

    public MutableLiveData<ArrayList<ProfileRepo>> getRepos(String userName) {

        final MutableLiveData<ArrayList<ProfileRepo>> responseContainerMutableLiveData = new MutableLiveData<ArrayList<ProfileRepo>>();

        commonApi.getRepos(userName).enqueue(new Callback<ArrayList<ProfileRepo>>() {
            @Override
            public void onResponse(Call<ArrayList<ProfileRepo>> call, Response<ArrayList<ProfileRepo>> response) {
                responseContainerMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<ProfileRepo>> call, Throwable t) {

            }
        });

        return responseContainerMutableLiveData;


    }
}
