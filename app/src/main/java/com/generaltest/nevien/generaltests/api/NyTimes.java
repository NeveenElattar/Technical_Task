package com.generaltest.nevien.generaltests.api;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.generaltest.nevien.generaltests.callback.OnStoriesRetrieveListener;
import com.generaltest.nevien.generaltests.util.Constant;

import org.json.JSONObject;

/**
 * Created by Nevien on 21/06/17.
 */

public class NyTimes {

    public static void retrieveTopStories(final OnStoriesRetrieveListener listener) {
        AndroidNetworking.get(Constant.Api.BASE_URL)
                .addQueryParameter(Constant.Api.API_KEY_QUERY_PARAMETER_STRING, Constant.Api.API_KEY)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        listener.onStoriesRetrieved(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        listener.onError(anError);
                    }
                });
    }
}
