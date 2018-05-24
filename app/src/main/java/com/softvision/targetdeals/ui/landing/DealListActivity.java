package com.softvision.targetdeals.ui.landing;

import android.arch.lifecycle.*;
import android.content.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v7.widget.*;
import android.support.v7.widget.Toolbar;
import android.widget.*;

import com.softvision.targetdeals.*;
import com.softvision.targetdeals.R;
import com.softvision.targetdeals.databinding.*;
import com.softvision.targetdeals.ui.base.*;
import com.softvision.targetdeals.utils.*;

import javax.inject.*;

public class DealListActivity extends BaseActivity<ActivityDealListBinding,DealsItemViewModel > implements DealsNavigator,  DealsItemAdapter.DealsAdapterListener {

    @Inject
    LinearLayoutManager mLayoutManager;

    @Inject
    SimpleDividerItemDecoration mSimpleDividerItemDecoration;
    @Inject
    DealsItemAdapter mDealsItemAdapter;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private DealsItemViewModel mDealsItemViewModel;
    private ActivityDealListBinding mActivityDealListBinding;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent( context, DealListActivity.class );
        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK );
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.dealsViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.deals_list;
    }

    @Override
    public DealsItemViewModel getViewModel() {
        mDealsItemViewModel = ViewModelProviders.of( this, mViewModelFactory ).get(
                DealsItemViewModel.class );
        return mDealsItemViewModel;
    }

    @Override
    public void intiBinding() {
        setUp();
        subscribeToLiveData();
        setSupportActionBar(mToolbar);
    }

    private void setUp() {
        mToolbar = mActivityDealListBinding.toolbar;
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mActivityDealListBinding.dealsRecyclerView.setLayoutManager(mLayoutManager);
        mActivityDealListBinding.dealsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mActivityDealListBinding.dealsRecyclerView.addItemDecoration(mSimpleDividerItemDecoration);
        mActivityDealListBinding.dealsRecyclerView.setAdapter( mDealsItemAdapter );
    }

    private void subscribeToLiveData() {
        mDealsItemViewModel.getDealListLiveData().observe(this,  datumList-> mDealsItemViewModel.addDealItemsToList(datumList));
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
        mDealsItemViewModel.setNavigator( this );
        mDealsItemAdapter.setListener(this);
        mActivityDealListBinding = getViewDataBinding( );
        intiBinding( );
    }

    @Override
    protected void onResume() {
        super.onResume( );

    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onRetryClick() {
        mDealsItemViewModel.getDeals();
    }

   
}
