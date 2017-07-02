package com.generaltest.nevien.generaltests.database;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.generaltest.nevien.generaltests.model.Item;
import com.generaltest.nevien.generaltests.util.Constant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by Nevien on 04/03/17.
 */

public class SharedPreferenceHelper {

    private static SharedPreferenceHelper mSharedPreferenceHelper;
    private static SharedPreferences sharedPreferences;

    private SharedPreferenceHelper() {

    }

    public static void init(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static SharedPreferenceHelper getInstance() {
        if (mSharedPreferenceHelper == null) {
            synchronized (SharedPreferenceHelper.class) {
                if (mSharedPreferenceHelper == null) {
                    mSharedPreferenceHelper = new SharedPreferenceHelper();
                }
            }
        }
        return mSharedPreferenceHelper;
    }

    public void saveItems(Context mContext, List<Item> items) {
        String verificationString = new Gson().toJson(items);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
        editor.putString(Constant.SharedPreference.ITEMS, verificationString);
        editor.apply();
    }

    public void saveSections(Context mContext, List<String> sections) {
        String verificationString = new Gson().toJson(sections);
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(mContext).edit();
        editor.putString(Constant.SharedPreference.SECTIONS, verificationString);
        editor.apply();
    }

    public List<Item> getItems() {
        String verificationString = sharedPreferences.getString(Constant.SharedPreference.ITEMS, "");
        return new Gson().fromJson(verificationString, new TypeToken<List<Item>>() {
        }.getType());
    }

    public List<String> getSections() {
        String verificationString = sharedPreferences.getString(Constant.SharedPreference.SECTIONS, "");
        return new Gson().fromJson(verificationString, new TypeToken<List<String>>() {
        }.getType());
    }

}
