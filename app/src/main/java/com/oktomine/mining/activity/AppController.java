package com.oktomine.mining.activity;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

/**
 * Created by Ravi Shankar on 4/30/2017.
*/

public class AppController extends Application {

public static final String TAG = AppController.class.getSimpleName();
private static AppController mInstance;

public static synchronized AppController getInstance() {
    return mInstance;
}


@Override
public void onCreate() {
    super.onCreate();
    mInstance = this;
}

@Override
protected void attachBaseContext(Context base) {
    super.attachBaseContext(base);
    MultiDex.install(this);
}

public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
    ConnectivityReceiver.connectivityReceiverListener = listener;
}
}
