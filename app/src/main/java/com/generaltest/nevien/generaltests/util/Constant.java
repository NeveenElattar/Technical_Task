package com.generaltest.nevien.generaltests.util;

/**
 * Created by Nevien on 21/06/17.
 */

public interface Constant {
    interface Api {
        String BASE_URL = "https://api.nytimes.com/svc/topstories/v2/home.json";
        String API_KEY = "db1ec6d4daf846d4b69e3c5262270678";
        String API_KEY_QUERY_PARAMETER_STRING = "api-key";
        String PLACE_HOLDER_IMAGE_URL = "https://vignette1.wikia.nocookie.net/theannoyingroleplayers/images/4/47/Placeholder.png";
    }

    interface SharedPreference {

        String ITEMS = "items";
        String SECTIONS = "sections";
    }

    interface Json {
        String RESULTS = "results";
        String SECTION = "section";
        String TITLE = "title";
        String PUBLISH_DATE = "published_date";
        String MULTIMEDIA = "multimedia";
        String URL = "url";
    }
}
