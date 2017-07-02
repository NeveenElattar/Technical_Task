package com.generaltest.nevien.generaltests.util;

import android.content.Context;

import com.generaltest.nevien.generaltests.database.SharedPreferenceHelper;
import com.generaltest.nevien.generaltests.model.Item;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nevien on 21/06/17.
 */

public class JsonParser {

    public static void parseAndCache(JSONObject object, Context mConstant) {

        List<String> sections = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        JSONArray results = object.optJSONArray(Constant.Json.RESULTS);

        for (int i = 0; i < results.length(); i++) {
            JSONObject jsonObject = results.optJSONObject(i);
            String sectionName = jsonObject.optString(Constant.Json.SECTION);

            if (!sections.contains(sectionName))
                sections.add(sectionName);

            String title = jsonObject.optString(Constant.Json.TITLE);
            String publishDate = jsonObject.optString(Constant.Json.PUBLISH_DATE);

            JSONArray multimedia = jsonObject.optJSONArray(Constant.Json.MULTIMEDIA);
            String url = Constant.Api.API_KEY_QUERY_PARAMETER_STRING;
            if (multimedia.length() > 0)
                url = multimedia.optJSONObject(0).optString(Constant.Json.URL);


            Item item = new Item();
            item.setSection(sectionName);
            item.setPublish(publishDate);
            item.setTitle(title);
            item.setUrl(url);

            items.add(item);

        }

        SharedPreferenceHelper.getInstance().saveItems(mConstant, items);
        SharedPreferenceHelper.getInstance().saveSections(mConstant, sections);

    }
}
