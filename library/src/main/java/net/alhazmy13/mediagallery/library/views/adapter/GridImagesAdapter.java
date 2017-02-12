package net.alhazmy13.mediagallery.library.views.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import net.alhazmy13.mediagallery.library.R;
import net.alhazmy13.mediagallery.library.views.MediaGalleryView;

import java.util.ArrayList;


public class GridImagesAdapter extends RecyclerView.Adapter<GridImagesAdapter.ViewHolder> {
    private static final String TAG = "GridImagesAdapter";
    private ArrayList<String> imageURLs;
    private Context mContext;
    private Drawable imgPlaceHolderResId ;
    private MediaGalleryView.OnImageClicked mClickListener;

    public GridImagesAdapter(Context activity, ArrayList<String> imageURLs, Drawable imgPlaceHolderResId) {
        this.imageURLs = imageURLs;
        this.mContext = activity;
        this.imgPlaceHolderResId = imgPlaceHolderResId;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.with(mContext)
                .load(imageURLs.get(holder.getAdapterPosition()))
                .placeholder(imgPlaceHolderResId)
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mClickListener == null) return;
                mClickListener.onImageClicked(holder.getAdapterPosition());
            }
        });
    }


    public void setImgPlaceHolder(Drawable imgPlaceHolderResId) {
        this.imgPlaceHolderResId = imgPlaceHolderResId;
    }

    @Override
    public int getItemCount() {
        return imageURLs.size();
    }

    public void setOnImageClickListener(MediaGalleryView.OnImageClicked onImageClickListener) {
        this.mClickListener = onImageClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;

        ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }


}
