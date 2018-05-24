/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.softvision.targetdeals.login;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.data.model.auth.*;
import com.softvision.targetdeals.rx.*;
import com.softvision.targetdeals.ui.login.*;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

import io.reactivex.*;
import io.reactivex.schedulers.*;

import static org.mockito.Mockito.*;

/**
 * Created by amitshekhar on 11/07/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    @Mock
    LoginNavigator mLoginCallback;
    @Mock
    DataManager mMockDataManager;
    private LoginViewModel mLoginViewModel;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() {
    }

    @Before
    public void setUp() {
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginViewModel = new LoginViewModel(mMockDataManager, testSchedulerProvider);
        mLoginViewModel.setNavigator(mLoginCallback);
    }

    @After
    public void tearDown() {
        mTestScheduler = null;
        mLoginViewModel = null;
        mLoginCallback = null;
    }

    @Test
    public void testServerLoginSuccess() {
        String email = "dummy@gmail.com";
        String password = "password";

        RequestTokenResponse requestTokenResponse = new RequestTokenResponse();

        doReturn(Single.just(requestTokenResponse))
                .when(mMockDataManager)
                .requestToken( BuildConfig.API_KEY);

        mLoginViewModel.getRequestToken(email,password);
        mTestScheduler.triggerActions();

        verify(mLoginCallback).onTokenRequestSuccess(requestTokenResponse.getRequestToken());
    }
}
