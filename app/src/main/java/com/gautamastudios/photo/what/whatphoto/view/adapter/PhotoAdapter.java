package com.gautamastudios.photo.what.whatphoto.view.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;
import com.gautamastudios.photo.what.whatphoto.GlideApp;
import com.gautamastudios.photo.what.whatphoto.GlideRequest;
import com.gautamastudios.photo.what.whatphoto.R;
import com.gautamastudios.photo.what.whatphoto.api.model.Photo;
import com.gautamastudios.photo.what.whatphoto.api.model.PhotoResponse;

import java.util.ArrayList;
import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {

    private int totalPageCount;
    private List<Photo> photos;

    public PhotoAdapter() {
        photos = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.photo_item, parent, false), parent.getContext());
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Photo photo = getItem(position);
        holder.photo.setMaxWidth(photo.width);
        holder.photo.setMaxHeight(photo.height);
        loadImage(photo.imageUrl, holder.getContext(), photo.width, photo.height).into(holder.photo);
    }

    private GlideRequest<Drawable> loadImage(@NonNull String posterPath, Context context, int width, int height) {
        return GlideApp.with(context).load(posterPath).diskCacheStrategy(DiskCacheStrategy.ALL).fitCenter().override(
                Target.SIZE_ORIGINAL);
    }

    @Override
    public int getItemCount() {
        return this.photos == null ? 0 : this.photos.size();
    }

    private Photo getItem(int position) {
        return this.photos.get(position);
    }

    public void setPhotoResponse(PhotoResponse photoResponse) {
        totalPageCount = photoResponse.totalPages;
        for (Photo photo : photoResponse.photos) {
            this.photos.add(photo);
        }
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photo;
        private Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            photo = itemView.findViewById(R.id.photo_image_view);
        }

        public Context getContext() {
            return context;
        }
    }
}
