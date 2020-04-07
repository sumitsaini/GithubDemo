package com.github.carrerfour.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.Repo.NewsRepository;
import com.github.carrerfour.model.ProfileDetail;

public class UserInputViewModel extends AndroidViewModel {

    private MutableLiveData<ProfileDetail> profileDetailMutableLiveData;
    private NewsRepository newsRepository;

    public UserInputViewModel(Application application) {
        super(application);
        newsRepository = new NewsRepository();
    }

    public void getDetails(String userName) {
        if (profileDetailMutableLiveData == null) {
            profileDetailMutableLiveData = new MutableLiveData<ProfileDetail>();
        }

        profileDetailMutableLiveData = newsRepository.getDetails(userName);
    }

    public MutableLiveData<ProfileDetail> getProfileDetailMutableLiveData() {
        return profileDetailMutableLiveData;
    }
}
