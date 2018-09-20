package com.example.jessi.rjt_project_01.data.database;

import com.example.jessi.rjt_project_01.data.IDataManager;

public interface IDBHelper {

    public void createRow();
    public void readRow(IDataManager.OnResponseListener listener);
    public void updateRow();
    public void deleteRow();
}
