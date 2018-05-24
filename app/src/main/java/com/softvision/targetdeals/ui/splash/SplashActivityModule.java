package com.softvision.targetdeals.ui.splash;

import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.utils.rx.*;

import dagger.*;

@Module
public abstract class SplashActivityModule {

    @Provides
    static SplashViewModel providesSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider ){
        return new SplashViewModel(dataManager,schedulerProvider);
    }
}
