package com.github.carrerfour.repo;

import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.repo.services.CommonApi;
import com.github.carrerfour.repo.services.RetrofitService;
import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.model.ProfileRepo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorsRepository {

    private CommonApi commonApi;
    private final String TAG = AuthorsRepository.class.getSimpleName();

    public AuthorsRepository() {
        commonApi = RetrofitService.getInstance().create(CommonApi.class);
    }


    public MutableLiveData<ProfileDetail> getDetails(String userName) {

        final MutableLiveData<ProfileDetail> responseContainerMutableLiveData = new MutableLiveData<ProfileDetail>();

        commonApi.getDetail(userName).enqueue(new Callback<ProfileDetail>() {
            @Override
            public void onResponse(Call<ProfileDetail> call, Response<ProfileDetail> response) {
                if (response != null && response.body() != null) {
                    ProfileDetail profileDetail = response.body();
                    profileDetail.setSuccess(true);
                    responseContainerMutableLiveData.postValue(profileDetail);
                } else {
                    ProfileDetail profileDetail = new ProfileDetail();
                    profileDetail.setSuccess(false);
                    profileDetail.setErrorMessage("No data found");
                    responseContainerMutableLiveData.postValue(profileDetail);
                }

            }

            @Override
            public void onFailure(Call<ProfileDetail> call, Throwable t) {
                ProfileDetail profileDetail = new ProfileDetail();
                profileDetail.setSuccess(false);
                profileDetail.setErrorMessage(t.getMessage());
                responseContainerMutableLiveData.postValue(profileDetail);
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
                responseContainerMutableLiveData.postValue(null);
            }
        });

        return responseContainerMutableLiveData;


    }
}
