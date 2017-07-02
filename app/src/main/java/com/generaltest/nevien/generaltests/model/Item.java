package com.generaltest.nevien.generaltests.model;

/**
 * Created by Nevien on 6/21/2017.
 */

public class Item {
    private String section;
    private String url;
    private String title;
    private String publish;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
