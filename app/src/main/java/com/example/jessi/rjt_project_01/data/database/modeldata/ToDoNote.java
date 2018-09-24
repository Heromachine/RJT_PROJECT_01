package com.example.jessi.rjt_project_01.data.database.modeldata;

public class ToDoNote {

/**
 * this is my pojo -- plain old java object
 */
    String title;
    String subTitle;


    public ToDoNote(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}

