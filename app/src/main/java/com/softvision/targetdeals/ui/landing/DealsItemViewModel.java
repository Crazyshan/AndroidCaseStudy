
package com.softvision.targetdeals.ui.landing;

import android.arch.lifecycle.*;
import android.databinding.*;

import com.softvision.targetdeals.data.*;
import com.softvision.targetdeals.data.model.*;
import com.softvision.targetdeals.ui.base.*;
import com.softvision.targetdeals.utils.rx.*;

import java.util.*;


public class DealsItemViewModel extends BaseViewModel<DealsNavigator > {

    public final ObservableList<Datum> datumObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Datum>> mutableLiveData;

    public DealsItemViewModel(DataManager dataManager,
                         SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        mutableLiveData = new MutableLiveData<>();
        getDeals();
    }

    public void addDealItemsToList(List<Datum> dealsItem) {
        datumObservableArrayList.clear();
        datumObservableArrayList.addAll(dealsItem);
    }

    public MutableLiveData<List<Datum>> getDealListLiveData() {
        return mutableLiveData;
    }

    public ObservableList<Datum> getBlogObservableList() {
        return datumObservableArrayList;
    }
    public void getDeals() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getDeals()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(openSourceResponse -> {
                    if (openSourceResponse != null && openSourceResponse.getData() != null) {
                        mutableLiveData.setValue(openSourceResponse.getData());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }
}
