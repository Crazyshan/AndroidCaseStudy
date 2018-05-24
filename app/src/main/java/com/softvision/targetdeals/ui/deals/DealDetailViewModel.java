package com.softvision.targetdeals.ui.deals;

import android.arch.lifecycle.*;
import android.content.*;
import android.databinding.*;
import android.widget.*;

import com.bumptech.glide.*;
import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.ui.base.*;
import com.softvision.targetdeals.utils.rx.*;

public class DealDetailViewModel extends BaseViewModel< DealDetailNavigator > {

    public final ObservableField< String > mTitle = new ObservableField<>( );
    public final ObservableField< String > imageUrl = new ObservableField<>( );
    public final ObservableField< String > mPrice = new ObservableField<>( );
    public final ObservableField< String > mSalesPrice = new ObservableField<>( );
    public final ObservableField< String > mDescription = new ObservableField<>( );
    private final MutableLiveData< Datum > mutableLiveData;

    public DealDetailViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super( dataManager, schedulerProvider );
        mutableLiveData = new MutableLiveData<>( );

    }

    public ObservableField< String > getTitle() {
        return mTitle;
    }

  /*  public ObservableField< String > getImageUrl() {
        return mImageUrl;
    }*/

    public ObservableField< String > getPrice() {
        return mPrice;
    }

    public ObservableField< String > getSalesPrice() {
        return mSalesPrice;
    }

    public ObservableField< String > getDescription() {
        return mDescription;
    }

    public void updateProduct(Datum datum) {
        mutableLiveData.setValue( datum );
        mTitle.set( datum.getTitle( ) );
        mPrice.set( datum.getPrice( ) );

        mSalesPrice.set( datum.getSalePrice( ) );
        mDescription.set( datum.getDescription( ) );
        imageUrl.set( datum.getImage( ) );
    }

    public void onAddToList() {
        getNavigator( ).onAddToList( );
    }

    public void onAddToCart() {
        getNavigator( ).onAddToCart( );
    }

    public MutableLiveData< Datum > getDealListLiveData() {
        return mutableLiveData;
    }
    public String getImageUrl() {
        // The URL will usually come from a model (i.e Profile)
        return "http://cdn.meme.am/instances/60677654.jpg";
    }
    @BindingAdapter({"app:imageUrl"})
    public static void setIm(ImageView view, String imageUrl) {
        Context context = view.getContext();
        Glide.with(context).load(imageUrl).into(view);
    }

}
