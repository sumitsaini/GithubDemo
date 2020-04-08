package com.github.carrerfour;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.github.carrerfour.model.ProfileDetail;
import com.github.carrerfour.repo.AuthorsRepository;
import com.github.carrerfour.viewmodel.UserInputViewModel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(JUnit4.class)
public class AuthorDetailsUnitTest {

    @Mock
    AuthorsRepository authorsRepository;
    @Mock
    UserInputViewModel userInputViewModel;
    @Mock
    Observer<ProfileDetail> profileDetailObserver;
    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userInputViewModel = new UserInputViewModel();
        userInputViewModel.getProfileDetailMutableLiveData().observeForever(profileDetailObserver);

    }


    @Test
    public void testNull() {
        Mockito.when(authorsRepository.getDetails("sumitsaini")).thenReturn(null);
        Assert.assertNotNull(userInputViewModel.getProfileDetailMutableLiveData());
        Assert.assertTrue(userInputViewModel.getProfileDetailMutableLiveData().hasObservers());
    }


    @After
    public void tearDown() {
        authorsRepository = null;
        userInputViewModel = null;
        profileDetailObserver = null;
    }

}