package com.gautamastudios.photo.what.whatphoto.api;

import android.net.Uri;

public class APIService {

    //// TODO: 2017/09/04 hide in app
    private static final String hideinapp = "FR88IA2J6kavxRCXQkLye3NyNfdZSUBM9H5MP7GG";

    //// TODO: 2017/09/04 Build in all params
    //https://github.com/500px/api-documentation/blob/master/endpoints/photo/GET_photos.md

    //// TODO: 2017/09/04 add gitignore

    //// TODO: 2017/09/04 setup UI unit tests


    private static String buildURL() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https").authority("api.500px.com").appendPath("v1").appendPath(
                "photos").appendQueryParameter("consumer_key", hideinapp);

        return builder.build().toString();
    }



}
