package com.gautamastudios.photo.what.whatphoto;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.gautamastudios.photo.what.whatphoto.api.APICallback;
import com.gautamastudios.photo.what.whatphoto.api.APIService;
import com.gautamastudios.photo.what.whatphoto.api.model.PhotoResponse;
import com.gautamastudios.photo.what.whatphoto.view.EndlessScrollListener;
import com.gautamastudios.photo.what.whatphoto.view.adapter.PhotoAdapter;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //the full documentation
    //https://github.com/500px/api-documentation

    // the project
    //https://500px.com/settings/applications

    //// TODO: 2017/09/04 Endless scroller documentation
    //https://github.com/codepath/android_guides/wiki/Endless-Scrolling-with-AdapterViews-and-RecyclerView

    private RecyclerView recyclerView;
    private PhotoResponse photoResponse;
    private PhotoAdapter photoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_endless_scroller);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lm);

        photoAdapter = new PhotoAdapter();
        recyclerView.setAdapter(photoAdapter);

        recyclerView.addOnScrollListener(new EndlessScrollListener(lm) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.d("PAGIN", "Page : " + page + " - totalItemsCount : " + totalItemsCount);

                if (page <= photoAdapter.getTotalPageCount()) {
                    APIService.requestPhotos(new APICallback() {

                        @Override
                        public void onSuccess(JSONObject jsonObject) {
                            photoResponse = new Gson().fromJson(jsonObject.toString(), PhotoResponse.class);
                            Log.d("JOURNAL", new Gson().toJson(photoResponse));

                            photoAdapter.setPhotoResponse(photoResponse);
                            runLayoutAnimation(recyclerView, R.anim.layout_animation_from_right);
                        }

                        @Override
                        public void onFail(String message, int code) {

                        }
                    }, "", String.valueOf(page));
                }
            }
        });

        APIService.requestPhotos(new APICallback() {

            @Override
            public void onSuccess(JSONObject jsonObject) {
                photoResponse = new Gson().fromJson(jsonObject.toString(), PhotoResponse.class);
                Log.d("JOURNAL", new Gson().toJson(photoResponse));

                photoAdapter.setPhotoResponse(photoResponse);
                runLayoutAnimation(recyclerView, R.anim.layout_animation_from_right);
            }

            @Override
            public void onFail(String message, int code) {

            }
        }, "", "1");
    }

    private void runLayoutAnimation(final RecyclerView recyclerView, final int animationResourceID) {
        final Context context = recyclerView.getContext();

        final LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(context, animationResourceID);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
}
