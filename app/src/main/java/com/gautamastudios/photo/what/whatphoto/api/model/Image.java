package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("size")
    public int size;

    @SerializedName("url")
    public String url;

    @SerializedName("https_url")
    public String httpsUrl;

    @SerializedName("format")
    public String format;
}