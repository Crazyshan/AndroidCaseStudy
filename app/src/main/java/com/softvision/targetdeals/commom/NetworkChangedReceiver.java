package com.softvision.targetdeals.commom;

import android.content.*;

import com.softvision.targetdeals.utils.*;

import javax.inject.*;

public class NetworkChangedReceiver extends BroadcastReceiver {

    public static IConnectivityReceiverListener connectivityReceiverListener;

    @Inject
    public NetworkChangedReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {
        boolean isConnected = NetworkUtil.isConnected(context);
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }
}
