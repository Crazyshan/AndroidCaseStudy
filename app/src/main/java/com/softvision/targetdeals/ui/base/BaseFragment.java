package com.softvision.targetdeals.ui.base;

import android.content.*;
import android.databinding.*;
import android.os.*;
import android.support.annotation.*;
import android.view.*;

import dagger.android.support.*;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends DaggerFragment {

    private T mViewDataBinding;
    private V mViewModel;
    private BaseActivity mActivity;
    private View mRootView;

    /**Overides for set binding variable
     *
     * @return variable Id
     */
    public abstract int getBindingVariable();

    /**
     *
     * @return Layout resource Id.
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Overides for set View Model
     * @return view model instance
     */
    public abstract V getViewModel();

    public T getViewDataBinding(){
        return mViewDataBinding;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        setHasOptionsMenu(false);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;*/
        mViewDataBinding=DataBindingUtil.inflate(inflater,getLayoutId(),container,false);
        mRootView=mViewDataBinding.getRoot();
        return mRootView;
    }

    @Override
    public void onDetach() {
        mActivity=null;
        super.onDetach();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       mViewDataBinding.setVariable(getBindingVariable(),mViewModel);
       mViewDataBinding.executePendingBindings();

    }
    public BaseActivity getBaseActivity() {
        return mActivity;
    }
    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }
}
