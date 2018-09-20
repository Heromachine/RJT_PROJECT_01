package com.example.jessi.rjt_project_01.data;

import com.example.jessi.rjt_project_01.data.database.DBHelper;
import com.example.jessi.rjt_project_01.data.database.IDBHelper;

public class DataManager implements  IDataManager{
    IDBHelper idbHelper;

    public DataManager() {
        this.idbHelper = new DBHelper();
    }

    @Override
    public void createRow() {

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
