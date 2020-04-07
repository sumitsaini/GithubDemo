package com.github.carrerfour.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.Repo.NewsRepository;
import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.model.ProfileRepo;

import java.util.ArrayList;

public class UserDetailViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<ProfileRepo>> profileRepoMutableData;
    private NewsRepository newsRepository;

    public UserDetailViewModel(Application application) {
        super(application);
        newsRepository = new NewsRepository();
    }

    public void getRepos(String userName) {
        if (profileRepoMutableData == null) {
            profileRepoMutableData = new MutableLiveData<ArrayList<ProfileRepo>>();
        }

        profileRepoMutableData = newsRepository.getRepos(userName);
    }

    public MutableLiveData<ArrayList<ProfileRepo>> getProfileRepoMutableData() {
        return profileRepoMutableData;
    }
}

