package com.github.carrerfour.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.repo.AuthorsRepository;
import com.github.carrerfour.model.ProfileRepo;

import java.util.ArrayList;

public class UserDetailViewModel extends AndroidViewModel {

    private AuthorsRepository newsRepository;

    public UserDetailViewModel(Application application) {
        super(application);
        newsRepository = new AuthorsRepository();
    }

    public MutableLiveData<ArrayList<ProfileRepo>> getRepos(String userName) {
        return newsRepository.getRepos(userName);
    }
}

