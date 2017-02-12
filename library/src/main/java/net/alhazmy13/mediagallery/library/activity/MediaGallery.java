package net.alhazmy13.mediagallery.library.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;


import net.alhazmy13.mediagallery.library.Constants;

import java.util.ArrayList;


public class MediaGallery {
    private Context mActivity;
    private ArrayList<String> mDataset;
    private String mTitle;
    private int mSelectedImagePosition;
    @ColorRes
    private int mBackgroundColor;
    @DrawableRes
    private int mPlaceHolder;

    public static MediaGallery Builder(Activity activity, ArrayList<String> imagesURLs) {
        return new MediaGallery(activity, imagesURLs);
    }


    private MediaGallery(Context context, ArrayList<String> imagesList) {
        this.mDataset = imagesList;
        this.mActivity = context;
    }

    public MediaGallery title(String title) {
        this.mTitle = title;
        return this;
    }

    public MediaGallery backgroundColor(@ColorRes int color){
        this.mBackgroundColor = color;
        return this;
    }
    public MediaGallery placeHolder(@DrawableRes int placeholder) {
        this.mPlaceHolder = placeholder;
        return this;
    }

    public MediaGallery selectedImagePosition(int position) {
        this.mSelectedImagePosition = position;
        return this;
    }


    public void show() {
        Intent intent = new Intent(mActivity, MediaGalleryActivity.class);
        intent.putExtra(Constants.IMAGES, mDataset);
        intent.putExtra(Constants.TITLE, mTitle);
        intent.putExtra(Constants.BACKGROUND_COLOR,mBackgroundColor);
        intent.putExtra(Constants.PLACE_HOLDER,mPlaceHolder);
        intent.putExtra(Constants.SELECTED_IMAGE_POSITION,mSelectedImagePosition);
        mActivity.startActivity(intent);
    }



}
