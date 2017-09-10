package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.annotations.SerializedName;

public class Filter {

    @SerializedName("category")
    public boolean category;

    @SerializedName("exclude")
    public boolean exclude;
}
