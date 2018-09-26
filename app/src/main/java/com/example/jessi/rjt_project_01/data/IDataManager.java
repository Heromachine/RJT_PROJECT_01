package com.example.jessi.rjt_project_01.data;

import com.example.jessi.rjt_project_01.data.database.IDBHelper;

public interface IDataManager  extends IDBHelper{

    interface OnResponseListener {
        public void getTodoNote(String s);
    }
}
