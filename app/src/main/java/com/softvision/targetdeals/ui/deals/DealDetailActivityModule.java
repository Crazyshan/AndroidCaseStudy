package com.softvision.targetdeals.ui.deals;

import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.utils.rx.*;

import dagger.*;

@Module
public class DealDetailActivityModule {
    @Provides
    static DealDetailViewModel providesDealDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){

        return new DealDetailViewModel( dataManager,schedulerProvider ) ;
    }
}
