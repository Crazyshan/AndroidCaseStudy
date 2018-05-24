package com.softvision.targetdeals.di.builder;

import com.softvision.targetdeals.ui.deals.*;
import com.softvision.targetdeals.ui.landing.*;
import com.softvision.targetdeals.ui.splash.*;

import dagger.*;
import dagger.android.*;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = {DealListActivityModule.class})
    abstract DealListActivity bindDetailActivity();

    @ContributesAndroidInjector(modules = {DealDetailActivityModule.class})
    abstract DealDetailActivity bindDealDetailActivity();

}

