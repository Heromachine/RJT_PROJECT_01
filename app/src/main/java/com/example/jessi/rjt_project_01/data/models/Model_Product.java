package com.example.jessi.rjt_project_01.data.models;

import android.util.Log;

public class Model_Product {
    private static final String TAG = "Model_Product";
    private String id;
    private String name;
    private String description;
    private String url;

    public Model_Product()
    {

    }
    public Model_Product(String id, String name, String description, String url) {
        Log.d(TAG, "Model_Product: =============================NEW MODEL CALL");

        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
