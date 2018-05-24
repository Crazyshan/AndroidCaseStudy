package com.softvision.targetdeals.ui.deals;

import android.arch.lifecycle.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v7.widget.*;
import android.widget.*;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.R;
import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.databinding.*;
import com.softvision.targetdeals.ui.base.*;

import javax.inject.*;

public class DealDetailActivity extends BaseActivity<DealDetailBinding,
        DealDetailViewModel > implements DealDetailNavigator {
    @Inject
    DealDetailViewModel mDealDetailViewModel;

    DealDetailBinding mDealDetailBinding;

    public static Intent newIntent(Context context, Datum datum) {
        Intent intent = new Intent( context, DealDetailActivity.class );
        Bundle mBundle = new Bundle();
        mBundle.putParcelable("Data", datum);
        intent.putExtras(mBundle);
        return intent;
    }

    @Override
    public void onAddToCart() {
        Toast.makeText( this, "Add to Cart", Toast.LENGTH_SHORT ).show( );
    }

    @Override
    public void onAddToList() {
        Toast.makeText( this, "Add to List", Toast.LENGTH_SHORT ).show( );
    }

    @Override
    public int getBindingVariable() {
        return BR.dealDetailViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.detail_activity;
    }

    @Override
    public DealDetailViewModel getViewModel() {
       return mDealDetailViewModel;
    }

    @Override
    public void intiBinding() {
        mDealDetailBinding = getViewDataBinding( );
               mDealDetailViewModel.setNavigator( this );
        if (getIntent().getExtras().getParcelable("Data")!=null) {
            Datum datum = getIntent().getExtras().getParcelable("Data");
            mDealDetailViewModel.updateProduct(datum);
            mDealDetailViewModel.getDealListLiveData();
        }
    }



    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        networkStatus( isConnected );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed( );
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
               intiBinding( );
    }

    @Override
    protected void onResume() {
        super.onResume( );

    }


}
