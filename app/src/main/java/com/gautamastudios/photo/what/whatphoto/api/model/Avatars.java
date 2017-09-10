package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class Avatars {

    @SerializedName("default")
    public JsonObject defaultAvatar;

    @SerializedName("large")
    public JsonObject largeAvatar;

    @SerializedName("small")
    public JsonObject smallAvatar;

    @SerializedName("tiny")
    public JsonObject tinyAvatar;
}