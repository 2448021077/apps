package com.zhangteng.imagepicker.imageloader;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Swing on 2018/4/18.
 */
public class GlideImageLoader implements ImageLoader {
    @Override
    public void loadImage(Context context, ImageView imageView, String uri) {
        Picasso.with(imageView.getContext())
                .load(new File(uri))
                .resize(1000,1000)
                .centerCrop()
                .into(imageView);


    }
}
