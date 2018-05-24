package com.softvision.targetdeals.ui.landing;

import android.arch.lifecycle.*;
import android.content.*;
import android.support.v7.widget.*;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.di.scope.*;
import com.softvision.targetdeals.utils.*;
import com.softvision.targetdeals.utils.rx.*;

import dagger.*;

@Module
public class DealListActivityModule {
    @Provides
    LinearLayoutManager provideLinearLayoutManager(@ApplicationContext Context context) {
        return new LinearLayoutManager(context);
    }

    @Provides
    SimpleDividerItemDecoration providesSimpleDividerItemDecoration(@ApplicationContext Context context){
        return new SimpleDividerItemDecoration(context) ;
    }



    @Provides
    DealsItemAdapter provideOpenSourceAdapter(@ApplicationContext Context context) {
        return new DealsItemAdapter(context);
    }
    @Provides
    ViewModelProvider.Factory mainViewModelProvider(DealsItemViewModel appLandingModelView) {
        return new ViewModelProviderFactory<>(appLandingModelView);
    }

    @Provides
    static DealsItemViewModel providesLandingModelView(DataManager dataManager, SchedulerProvider schedulerProvider){

        return new DealsItemViewModel( dataManager,schedulerProvider ) ;
    }
}
