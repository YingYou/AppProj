package com.wt.photo.select.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.squareup.picasso.Picasso;

import java.io.File;

import cn.finalteam.galleryfinal.widget.GFImageView;

/**
 * Created by 吴同 on 2016/8/2 0002.
 */
class PhotoSelectPicassoImageLoader implements cn.finalteam.galleryfinal.ImageLoader {

    private Bitmap.Config mConfig;

    public PhotoSelectPicassoImageLoader() {
        this(Bitmap.Config.RGB_565);
    }

    public PhotoSelectPicassoImageLoader(Bitmap.Config config) {
        this.mConfig = config;
    }

    @Override
    public void displayImage(Activity activity, String path, GFImageView imageView, Drawable defaultDrawable, int width, int height) {
        Picasso.with(activity)
                .load(new File(path))
                .placeholder(defaultDrawable)
                .error(defaultDrawable)
                .config(mConfig)
                .resize(width, height)
                .centerInside()
//                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .into(imageView);
    }

    @Override
    public void clearMemoryCache() {
    }
}
