package com.softvision.targetdeals.di.component;

import android.app.*;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.di.builder.*;
import com.softvision.targetdeals.di.module.*;

import javax.inject.*;

import dagger.*;
import dagger.android.*;
import dagger.android.DaggerApplication;
import dagger.android.support.*;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,AppModule.class,ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    void inject(TargetDealsApplication app);
    @Override
    void inject(DaggerApplication instance);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
