package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    public int id;

    @SerializedName("username")
    public String userName;

    @SerializedName("firstname")
    public String firstName;

    @SerializedName("lastname")
    public String lastName;

    @SerializedName("city")
    public String city;

    @SerializedName("country")
    public String country;

    @SerializedName("usertype")
    public int userType;

    @SerializedName("fullname")
    public String fullName;

    @SerializedName("userpic_url")
    public String userpicUrl;

    @SerializedName("userpic_https_url")
    public String userpicHttpsUrl;

    @SerializedName("cover_url")
    public String coverUrl;

    @SerializedName("upgrade_status")
    public int upgradeStatus;

    @SerializedName("store_on")
    public boolean storeOn;

    @SerializedName("affection")
    public int affection;

    @SerializedName("avatars")
    public Avatars avatars;
}
