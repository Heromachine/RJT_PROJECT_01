package com.example.jessi.rjt_project_01.data.database.modeldata;

import android.provider.BaseColumns;

public final class ToDoContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public ToDoContract() {}

    /* Inner class that defines the table contents */
    public static abstract class ToDoEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";

    }
}