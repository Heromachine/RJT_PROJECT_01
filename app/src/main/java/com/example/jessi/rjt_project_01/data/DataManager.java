package com.example.jessi.rjt_project_01.data;

import com.example.jessi.rjt_project_01.data.database.DBHelper;
import com.example.jessi.rjt_project_01.data.database.IDBHelper;
import com.example.jessi.rjt_project_01.data.database.modeldata.ToDoNote;

public class DataManager implements  IDataManager{
    IDBHelper idbHelper;



    @Override
    public void createRow(String title, String subTitle) {

    }

    @Override
    public void createRow(ToDoNote todoNote) {

    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener) {
        idbHelper.readRow(listener);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }

}
