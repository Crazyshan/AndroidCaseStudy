package com.softvision.targetdeals.data;

import android.content.*;

import com.google.gson.*;
import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.data.remote.*;
import com.softvision.targetdeals.di.scope.*;

import javax.inject.*;

import io.reactivex.*;

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;

    private final Gson mGson;

    private final ClientModuleImplement mClientModuleImplement;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ClientModuleImplement
            clientModule, Gson gson) {
        mContext = context;
        mGson = gson;
        mClientModuleImplement = clientModule;
    }



      public ApiHelper createRetrofitBody() {
        return mClientModuleImplement.createRetrofitBody( );
    }



    @Override
    public Observable< DealsResponse > getDeals() {
        return createRetrofitBody( ).getDeals( );
    }

   
}
