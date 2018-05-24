package com.softvision.targetdeals.di.module;

import android.app.*;
import android.content.*;

import com.google.gson.*;
import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.data.remote.*;
import com.softvision.targetdeals.di.scope.*;
import com.softvision.targetdeals.utils.rx.*;

import javax.inject.*;

import dagger.*;
import uk.co.chrisjenx.calligraphy.*;

@Module
public class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder( )
                .setDefaultFontPath( "fonts/source-sans-pro/SourceSansPro-Regular.ttf" )
                .setFontAttrId( R.attr.fontPath )
                .build( );
    }
    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder( ).excludeFieldsWithoutExposeAnnotation( ).create( );
    }

    @Provides
    SchedulerProvider providesSchedulerProvider() {
        return new AppSchedulerProvider( );
    }

    @Provides
    @Singleton
    DataManager providesDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ClientModuleImplement providesClientModuleImplement() {
        return new ClientModule( );
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


}
