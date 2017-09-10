package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotoResponse {

    @SerializedName("current_page")
    public int currentPage;

    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("total_items")
    public int totalItems;

    @SerializedName("photos")
    public List<Photo> photos;

    @SerializedName("filters")
    public Filter filters;

    @SerializedName("feature")
    public String feature;
}
