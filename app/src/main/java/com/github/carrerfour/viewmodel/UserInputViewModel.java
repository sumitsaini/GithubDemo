package com.github.carrerfour.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.github.carrerfour.repo.AuthorsRepository;
import com.github.carrerfour.model.ProfileDetail;

public class UserInputViewModel extends AndroidViewModel {

    private AuthorsRepository newsRepository;

    public UserInputViewModel(Application application) {
        super(application);
        newsRepository = new AuthorsRepository();
    }

    public MutableLiveData<ProfileDetail> getDetails(String userName) {
        return newsRepository.getDetails(userName);

    }

}
