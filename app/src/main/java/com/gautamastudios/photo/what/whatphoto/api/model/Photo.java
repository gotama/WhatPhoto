package com.gautamastudios.photo.what.whatphoto.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("id")
    public int id;

    @SerializedName("user_id")
    public int userId;

    @SerializedName("name")
    public String name;

    @SerializedName("description")
    public String description;

    @SerializedName("camera")
    public String camera;

    @SerializedName("lens")
    public String lens;

    @SerializedName("focal_length")
    public String focalLength;

    @SerializedName("iso")
    public String iso;

    @SerializedName("shutter_speed")
    public String shutterSpeed;

    @SerializedName("aperture")
    public String aperture;

    @SerializedName("times_viewed")
    public int timesViewed;

    @SerializedName("rating")
    public double rating;

    @SerializedName("status")
    public int status;

    @SerializedName("created_at")
    public String createdAtDate;

    @SerializedName("category")
    public int category;

    @SerializedName("latitude")
    public double latitude;

    @SerializedName("longitude")
    public double longitude;

    @SerializedName("taken_at")
    public String takenAtDate;

    @SerializedName("hi_res_uploaded")
    public int hiResUploaded;

    @SerializedName("for_sale")
    public boolean forSale;

    @SerializedName("width")
    public int width;

    @SerializedName("height")
    public int height;

    @SerializedName("votes_count")
    public int votesCount;

    @SerializedName("favorites_count")
    public int favoritesCount;

    @SerializedName("comments_count")
    public int commentsCount;

    @SerializedName("nsfw")
    public boolean nsfw;

    @SerializedName("sales_count")
    public int salesCount;

    @SerializedName("for_sale_date")
    public String forSaleDate;

    @SerializedName("highest_rating")
    public double highestRating;

    @SerializedName("highest_rating_date")
    public String highestRatingDate;

    @SerializedName("license_type")
    public int licenseType;

    @SerializedName("converted")
    public int converted;

    @SerializedName("collections_count")
    public int collectionsCount;

    @SerializedName("crop_version")
    public int cropVersion;

    @SerializedName("privacy")
    public boolean privacy;

    @SerializedName("profile")
    public boolean profile;

    @SerializedName("for_critique")
    public boolean forCritique;

    @SerializedName("critiques_callout_dismissed")
    public boolean critiquesCalloutDismissed;

    @SerializedName("image_url")
    public String imageUrl;

    @SerializedName("images")
    public List<Image> images;

    @SerializedName("url")
    public String url;

    @SerializedName("positive_votes_count")
    public int positiveVotesCount;

    @SerializedName("converted_bits")
    public int convertedBits;

    @SerializedName("watermark")
    public boolean watermark;

    @SerializedName("image_format")
    public String imageFormat;

    @SerializedName("user")
    public User user;

    @SerializedName("licensing_requested")
    public boolean licensingRequested;

    @SerializedName("licensing_suggested")
    public boolean licensingSuggested;

    @SerializedName("is_free_photo")
    public boolean isFreePhoto;
}