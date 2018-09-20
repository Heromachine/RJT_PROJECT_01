package com.example.jessi.rjt_project_01.data.database;

import com.example.jessi.rjt_project_01.data.IDataManager;

public class DBHelper implements IDBHelper {
    @Override
    public void createRow() {

    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener) {
        listener.getTodoNote("DBHELPER ");
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
