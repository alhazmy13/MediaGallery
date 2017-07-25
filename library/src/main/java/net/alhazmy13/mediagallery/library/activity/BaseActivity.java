package net.alhazmy13.mediagallery.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import net.alhazmy13.mediagallery.library.Constants;
import net.alhazmy13.mediagallery.library.R;
import java.util.ArrayList;


abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected ArrayList<String> dataSet;
    protected String title;
    @ColorRes
    protected int backgroundColor;
    @DrawableRes
    protected int placeHolder;
    protected int selectedImagePosition;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayoutId());
        initBase();
        onCreateActivity();
    }

    private void initBase() {
        initBaseValues();
        initBaseViews();

    }

    private void initBaseValues() {
        Intent intent = getIntent();
        if(intent == null || intent.getExtras() == null) return;
        Bundle bundle = intent.getExtras();
        dataSet = bundle.getStringArrayList(Constants.IMAGES);
        title = bundle.getString(Constants.TITLE);
        backgroundColor = bundle.getInt(Constants.BACKGROUND_COLOR,-1);
        placeHolder = bundle.getInt(Constants.PLACE_HOLDER,-1);
        selectedImagePosition = bundle.getInt(Constants.SELECTED_IMAGE_POSITION,0);

    }

    private void initBaseViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_media_gallery);
        if (getSupportActionBar() != null) {
            mToolbar.setVisibility(View.GONE);
            getSupportActionBar().setTitle(String.valueOf(title));
        } else {
            setSupportActionBar(mToolbar);
            mToolbar.setTitle(String.valueOf(title));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }


    protected abstract int getResourceLayoutId();

    protected abstract void onCreateActivity();
}
