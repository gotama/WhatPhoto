package com.gautamastudios.photo.what.whatphoto.api;

import android.net.Uri;
import android.text.TextUtils;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.gautamastudios.photo.what.whatphoto.WhatPhotoApplication;

import org.json.JSONObject;

import java.util.Locale;

public class APIService {

    private static final String SCHEME_VALUE = "https";
    private static final String AUTHORITY_VALUE = "api.500px.com";
    private static final String API_VERSION_VALUE = "v1";

    private static final String ERROR_MESSAGE = "Critical Error, No response";

    //// TODO: 2017/09/04 Build in all params
    //https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos.md

    private static String buildURL(String path, String photoID, String pageNumber) {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(SCHEME_VALUE).authority(AUTHORITY_VALUE).appendPath(API_VERSION_VALUE).appendPath(path);

        if (!TextUtils.isEmpty(photoID)) {
            builder.appendPath(photoID);
        }

        builder.appendQueryParameter("consumer_key", WhatPhotoApplication.getKey());

        if (!TextUtils.isEmpty(pageNumber)) {
            builder.appendQueryParameter("page", pageNumber);
        }

        builder.appendQueryParameter("image_size", "4");
        return builder.build().toString();
    }

    public static void requestPhotos(final APICallback apiCallback, String photoID, String pageNumber) {
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                buildURL("photos", photoID, pageNumber), null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    apiCallback.onSuccess(response);
                } else {
                    apiCallback.onFail(ERROR_MESSAGE, -1);
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                String message;
                int responseCode;
                if (error.networkResponse != null) {
                    responseCode = error.networkResponse.statusCode;
                    message = String.format(Locale.getDefault(), "%s : %d", error.getMessage(), responseCode);
                } else {
                    //TODO check for -1 on UI
                    responseCode = -1;
                    message = ERROR_MESSAGE;
                }

                apiCallback.onFail(message, responseCode);
            }
        });

        jsonObjReq.setRetryPolicy(new DefaultRetryPolicy(30000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        WhatPhotoApplication.getInstance().addToRequestQueue(jsonObjReq, "tag_json_obj");
    }

}
