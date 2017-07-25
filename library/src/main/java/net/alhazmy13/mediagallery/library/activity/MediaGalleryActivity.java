package net.alhazmy13.mediagallery.library.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import net.alhazmy13.mediagallery.library.R;
import net.alhazmy13.mediagallery.library.activity.adapter.CustomViewPager;
import net.alhazmy13.mediagallery.library.activity.adapter.HorizontalListAdapters;
import net.alhazmy13.mediagallery.library.activity.adapter.ViewPagerAdapter;


/**
 * The type Media gallery activity.
 */
public class MediaGalleryActivity extends BaseActivity implements ViewPager.OnPageChangeListener, HorizontalListAdapters.OnImgClick {
    private CustomViewPager mViewPager;
    private RecyclerView imagesHorizontalList;
    private HorizontalListAdapters hAdapter;
    private RelativeLayout mMainLayout;

    @Override
    protected int getResourceLayoutId() {
        return R.layout.activity_gallery;
    }

    @Override
    protected void onCreateActivity() {
        // init layouts
        initViews();

        mViewPager.setAdapter(new ViewPagerAdapter(this, dataSet, mToolbar, imagesHorizontalList));
        hAdapter = new HorizontalListAdapters(this, dataSet, this,placeHolder);
        imagesHorizontalList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        imagesHorizontalList.setAdapter(hAdapter);
        hAdapter.notifyDataSetChanged();
        mViewPager.addOnPageChangeListener(this);
        hAdapter.setSelectedItem(selectedImagePosition);
        mViewPager.setCurrentItem(selectedImagePosition);
    }

    private void initViews() {
        mViewPager = (CustomViewPager) findViewById(R.id.pager);
        imagesHorizontalList = (RecyclerView) findViewById(R.id.imagesHorizontalList);
        mMainLayout = (RelativeLayout) findViewById(R.id.mainLayout);
        if (backgroundColor != -1){
            mMainLayout.setBackgroundColor(ContextCompat.getColor(this,backgroundColor));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        imagesHorizontalList.smoothScrollToPosition(position);
        hAdapter.setSelectedItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(int pos) {
        mViewPager.setCurrentItem(pos, true);
    }


}
