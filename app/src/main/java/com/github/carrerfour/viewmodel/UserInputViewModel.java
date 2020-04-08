package com.github.carrerfour.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.github.carrerfour.repo.AuthorsRepository;
import com.github.carrerfour.model.ProfileDetail;

public class UserInputViewModel extends ViewModel {

    private AuthorsRepository newsRepository;
    private MutableLiveData<ProfileDetail> profileDetailMutableLiveData=new MutableLiveData<>();

    public UserInputViewModel() {
        newsRepository = new AuthorsRepository();
    }

    public MutableLiveData<ProfileDetail> getDetails(String userName) {
        profileDetailMutableLiveData= newsRepository.getDetails(userName);
        return profileDetailMutableLiveData;
    }

    public AuthorsRepository getNewsRepository() {
        return newsRepository;
    }

    public MutableLiveData<ProfileDetail> getProfileDetailMutableLiveData() {
        return profileDetailMutableLiveData;
    }
}
