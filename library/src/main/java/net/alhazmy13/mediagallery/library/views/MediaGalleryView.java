package net.alhazmy13.mediagallery.library.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import net.alhazmy13.mediagallery.library.R;
import net.alhazmy13.mediagallery.library.views.adapter.GridImagesAdapter;

import java.util.ArrayList;

/**
 * Created by alhazmy13 on 2/12/17.
 */

public class MediaGalleryView extends RecyclerView {
    private static final String TAG = "MediaGalleryView";
    private final Context mContext;
    private GridImagesAdapter mAdapter;
    private ArrayList<String> mItemList;
    private Drawable mPlaceHolder;
    private OnImageClicked mOnImageClickListener;
    private int mSpanCount;

    public MediaGalleryView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public MediaGalleryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.MediaGalleryView, 0, 0);
        mSpanCount = a.getInteger(R.styleable.MediaGalleryView_span_count,2);
        mPlaceHolder = a.getDrawable(R.styleable.MediaGalleryView_place_holder);
        init();

    }

    public void init(){
        mItemList = new ArrayList<>();
        mAdapter = new GridImagesAdapter(mContext,mItemList,mPlaceHolder);
        setLayoutManager(new GridLayoutManager(mContext,mSpanCount));
        setAdapter(mAdapter);
    }

    public void setImages(ArrayList<String> itemList){
        this.mItemList.clear();
        this.mItemList.addAll(itemList);
    }

    public void notifyDataSetChanged(){
        if(mAdapter!= null)
        mAdapter.notifyDataSetChanged();
    }

    public void setPlaceHolder(int placeHolder) {
        this.mPlaceHolder = ContextCompat.getDrawable(mContext,placeHolder);
        mAdapter.setImgPlaceHolder(mPlaceHolder);
    }

    public void setOnImageClickListener(OnImageClicked onImageClickListener) {
        this.mOnImageClickListener = onImageClickListener;
        mAdapter.setOnImageClickListener(mOnImageClickListener);
    }

    public void setSpanCount(int spanCount) {
        this.mSpanCount = spanCount;
        setLayoutManager(new GridLayoutManager(mContext,mSpanCount));

    }

    public interface OnImageClicked {
        void onImageClicked(int pos);
    }
}
