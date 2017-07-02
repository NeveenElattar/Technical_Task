package com.generaltest.nevien.generaltests.application;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.generaltest.nevien.generaltests.database.SharedPreferenceHelper;

/**
 * Created by Nevien on 21/06/17.
 */

public class GeneralTextApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());
        SharedPreferenceHelper.init(getApplicationContext());
    }
}
