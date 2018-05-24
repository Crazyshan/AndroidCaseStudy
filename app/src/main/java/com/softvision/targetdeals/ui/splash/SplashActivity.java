package com.softvision.targetdeals.ui.splash;

import android.os.*;
import android.support.annotation.*;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.databinding.*;
import com.softvision.targetdeals.ui.base.*;
import com.softvision.targetdeals.ui.landing.*;

import javax.inject.*;

public class SplashActivity extends BaseActivity< SplashActivityBinding, SplashViewModel >
        implements SplashNavigator {

    private static final long SPLASH_TIME_OUT = 5000;
    @Inject
    SplashViewModel mSplashViewModel;

    SplashActivityBinding mSplashScreenBinding;

    @Override
    public int getBindingVariable() {
        return BR.splashview;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_screen;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public void intiBinding() {
        mSplashScreenBinding = getViewDataBinding( );
        mSplashViewModel.setNavigator( this );
        mSplashViewModel.openDealsListActivity( );
    }

    @Override
    public void openDealsListActivity() {
            new Handler( ).postDelayed( new Runnable( ) {
                @Override
                public void run() {
                    startActivity( DealListActivity.newIntent( SplashActivity.this ) );
                    finish( );
                }
            }, SPLASH_TIME_OUT );


    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme( R.style.AppTheme );
        super.onCreate( savedInstanceState );
        intiBinding();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        networkStatus( isConnected );
    }
}
