package com.example.jessi.rjt_project_01.data.database;

import com.example.jessi.rjt_project_01.data.IDataManager;
import com.example.jessi.rjt_project_01.data.database.modeldata.ToDoNote;

public interface IDBHelper {

    public void createRow(String title, String subTitle);
    public void createRow(ToDoNote todoNote);

    public void readRow(IDataManager.OnResponseListener listener);
    public void updateRow();
    public void deleteRow();
}
