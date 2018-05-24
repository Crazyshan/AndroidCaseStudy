package com.softvision.targetdeals.data.remote;

import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.utils.rx.*;

import javax.inject.*;

import io.reactivex.*;

@Singleton
public class AppApiHelper implements ApiHelper {

    private final ClientModuleImplement mClientModule;
    private SchedulerProvider mSchedulerProvider;

    @Inject
    public AppApiHelper(ClientModuleImplement clientModule,
                        SchedulerProvider schedulerProvider
    ) {
        this.mClientModule = clientModule;
        this.mSchedulerProvider = schedulerProvider;

    }

    @Override
    public Observable< DealsResponse > getDeals() {
        return mClientModule.createRetrofitBody( ).getDeals( );
    }

}
