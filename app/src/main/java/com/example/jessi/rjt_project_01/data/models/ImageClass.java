package com.example.jessi.rjt_project_01.data.models;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.LruCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader;

public class ImageClass extends LruCache <String, Bitmap> implements ImageCache {

    public static int getDefaultLruCacheSize()
    {
        final int maxMemory = (int)(Runtime.getRuntime().maxMemory()/1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }

    public ImageClass() {
        this(getDefaultLruCacheSize());
    }

    public ImageClass(int sizeInKiloBytes){
        super(sizeInKiloBytes);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
}
