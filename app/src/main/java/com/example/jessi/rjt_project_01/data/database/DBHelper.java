package com.example.jessi.rjt_project_01.data.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.jessi.rjt_project_01.data.IDataManager;
import com.example.jessi.rjt_project_01.data.database.modeldata.ToDoContract;
import com.example.jessi.rjt_project_01.data.database.modeldata.ToDoNote;

public class DBHelper implements IDBHelper {
    private static final String TAG = "DbHelper";
    SQLiteDatabase database;
    DatabaseOpenHelper openHelper;

    public DBHelper(Context context){
       // openHelper = new DatabaseOpenHelper(context);
        database = openHelper.getWritableDatabase();
    }

    @Override
    public void createRow(String title, String subTitle) {
        ContentValues values = new ContentValues();
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_TITLE,title);
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_SUBTITLE,subTitle);
        database.insert(ToDoContract.ToDoEntry.TABLE_NAME,null,values);
    }

    @Override
    public void createRow(ToDoNote todoNote) {
        ContentValues values = new ContentValues();
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_TITLE,todoNote.getTitle());
        values.put(ToDoContract.ToDoEntry.COLUMN_NAME_SUBTITLE,todoNote.getSubTitle());
        database.insert(ToDoContract.ToDoEntry.TABLE_NAME,null,values);
    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener) {
        //return "sample todo note";
        Cursor cursor = database.query(ToDoContract.ToDoEntry.TABLE_NAME,null,null,null,null,null,null);
        int titleColumnIndex = cursor.getColumnIndexOrThrow(ToDoContract.ToDoEntry.COLUMN_NAME_TITLE);
        int subTitleColumnIndex = cursor.getColumnIndexOrThrow(ToDoContract.ToDoEntry.COLUMN_NAME_SUBTITLE);

        cursor.moveToLast();
        String result = cursor.getString(titleColumnIndex)+"\n"+cursor.getString(subTitleColumnIndex);

        listener.getTodoNote(result);//implementation
        //listener.getTodoNote(new TodoNote(cursor.getString(titleColumnIndex),cursor.getString(subTitleColumnIndex)));

    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}