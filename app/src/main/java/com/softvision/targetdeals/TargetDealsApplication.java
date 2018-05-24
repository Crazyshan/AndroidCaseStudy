package com.softvision.targetdeals;

import android.app.*;
import android.support.multidex.*;

import com.facebook.stetho.*;
import com.softvision.targetdeals.di.component.*;
import com.softvision.targetdeals.utils.*;

import javax.inject.*;

import dagger.android.*;
import uk.co.chrisjenx.calligraphy.*;

public class TargetDealsApplication extends MultiDexApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    CalligraphyConfig mCalligraphyConfig;
    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        Stetho.initializeWithDefaults(this);
        AppLogger.init();
        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
