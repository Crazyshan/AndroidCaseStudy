package com.softvision.targetdeals.data.remote;

import com.softvision.targetdeals.data.model.*;

import io.reactivex.*;
import retrofit2.http.*;

import static com.softvision.targetdeals.data.remote.ApiEndPoint.*;

public interface ApiHelper {

    @GET ( DEALS )
    Observable< DealsResponse > getDeals();




}
