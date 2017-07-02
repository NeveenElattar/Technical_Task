package com.generaltest.nevien.generaltests.callback;

import org.json.JSONObject;

/**
 * Created by Nevien on 21/06/17.
 */

public interface OnStoriesRetrieveListener {

    void onStoriesRetrieved(JSONObject jsonObject);

    void onError(Exception e);

}
