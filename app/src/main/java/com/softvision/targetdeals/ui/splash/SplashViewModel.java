package com.softvision.targetdeals.ui.splash;

import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.ui.base.*;
import com.softvision.targetdeals.utils.rx.*;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super( dataManager, schedulerProvider );
    }

    public void openDealsListActivity() {
        getNavigator().openDealsListActivity();
    }


}
