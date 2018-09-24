package com.example.jessi.rjt_project_01.data.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jessi.rjt_project_01.data.database.modeldata.ToDoContract.ToDoEntry;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ToDoEntry.TABLE_NAME + " (" +
                    ToDoEntry._ID + " INTEGER PRIMARY KEY," +
                    ToDoEntry.COLUMN_NAME_ENTRY_ID + TEXT_TYPE + COMMA_SEP +
                    ToDoEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    ToDoEntry.COLUMN_NAME_SUBTITLE+TEXT_TYPE+  " )";


//    public DbOpenHelper(Context context) {
//        super(context, ProductEntry.TABLE_NAME, null, VERSION);
//    }

    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseOpenHelper(Context context, String name, int version, SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
