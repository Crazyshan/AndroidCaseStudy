package com.softvision.targetdeals.utils;

import android.content.*;
import android.net.*;

/**
 * Created by shankar.kuppusamy on 04-10-2017.
 */

public class NetworkUtil {
    /**
     * Network Availability in the device, true is available and false indicates no network
     * connection
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager conMgr = ( ConnectivityManager ) context
                .getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo activeNetwork = conMgr.getActiveNetworkInfo( );

        if ( activeNetwork == null || !activeNetwork.isConnected( ) ) {
            return false;
        } else {
            return activeNetwork != null
                    && activeNetwork.isConnectedOrConnecting( );
        }
    }
}
