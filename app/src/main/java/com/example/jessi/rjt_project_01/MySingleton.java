package com.example.jessi.rjt_project_01;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.jessi.rjt_project_01.data.models.ImageClass;

//public class AppController extends Application {
//
//    private static final String TAG = "AppController";
//
//    private RequestQueue requestQueue;
//    private static AppController mInstance;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        mInstance = this;
//    }
//
//    public static synchronized AppController getInstance() {
//        return mInstance;
//    }
//
//    public RequestQueue getRequestQueue() {
//
//        if(requestQueue == null) {
//            requestQueue = Volley.newRequestQueue(getApplicationContext());
//        }
//        return requestQueue;
//    }
//
//    public  <T> void addToRequestQueue(Request<T> req, String tag) {
//        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
//        getRequestQueue().add(req);
//    }
//
//    public <T> void addToRequestQueue(Request<T> req) {
//        req.setTag(TAG);
//        getRequestQueue().add(req);
//    }
//
//    public void cancelPendingRequests(Object tag) {
//        if(requestQueue != null) {
//            requestQueue.cancelAll(tag);
//        }
//    }
//}
