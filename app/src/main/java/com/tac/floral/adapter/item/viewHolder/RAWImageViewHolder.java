package com.theabsolutecompany.floral.adapter.item.viewHolder;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;

import com.theabsolutecompany.floral.data.models.AlbumItem;
import com.theabsolutecompany.floral.imageDecoder.RAWImageBitmapRegionDecoder;

public class RAWImageViewHolder extends PhotoViewHolder {

    private ProgressBar progressBar;
    private boolean imageLoaded = false;

    public RAWImageViewHolder(AlbumItem albumItem, int position) {
        super(albumItem, position);
    }

    @Override
    public Class<? extends ImageRegionDecoder> getBitmapRegionDecoderClass() {
        return RAWImageBitmapRegionDecoder.class;
    }

    @Override
    void bindImageView(View view, View transitionView) {
        addProgressBar();
        super.bindImageView(view, transitionView);
    }

    @Override
    public void onImageLoaded() {
        super.onImageLoaded();
        imageLoaded = true;
        removeProgressBar();
    }

    private void addProgressBar() {
        if (!imageLoaded && progressBar == null) {
            ViewGroup itemView = (ViewGroup) this.itemView;
            progressBar = new ProgressBar(itemView.getContext());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            itemView.addView(progressBar, params);
        }
    }

    private void removeProgressBar() {
        ViewGroup itemView = (ViewGroup) this.itemView;
        if (progressBar != null && itemView != null) {
            itemView.removeView(progressBar);
            progressBar = null;
        }
    }
}
