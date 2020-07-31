package com.noobcode.brief.utils;

import android.content.Context;
import android.widget.ImageView;

import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.noobcode.brief.R;

public class GlideUtils {
    public static void loadImage(ImageView imageView, String url, CircularProgressDrawable cpd){
        RequestOptions options = new RequestOptions()
                .placeholder(cpd)
               // .fitCenter()
                .error(R.mipmap.error);
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(options)
                .load(url)
                .into(imageView);
    }

    public static CircularProgressDrawable getLoader(Context context){
        CircularProgressDrawable cpd = new CircularProgressDrawable(context);
        cpd.setStrokeWidth(10f);
        cpd.setCenterRadius(50f);
        cpd.start();
        return cpd;
    }
}
