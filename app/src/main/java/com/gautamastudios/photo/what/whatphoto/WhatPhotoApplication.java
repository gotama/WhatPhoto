package com.gautamastudios.photo.what.whatphoto;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class WhatPhotoApplication extends Application {

    private static final String TAG = WhatPhotoApplication.class.getSimpleName();

    private static WhatPhotoApplication photoApplication;
    private RequestQueue requestQueue;

    public static synchronized WhatPhotoApplication getInstance() {
        return photoApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        photoApplication = this;
    }

    /**
     * @param request to add to the queue
     * @param tag     value for canceling request
     * @param <T>     type of Request
     */
    public <T> void addToRequestQueue(Request<T> request, String tag) {
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(request);
    }

    private RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return requestQueue;
    }

    public static String getKey() {
        return BuildConfig.WHAT_KEY;
    }

}
