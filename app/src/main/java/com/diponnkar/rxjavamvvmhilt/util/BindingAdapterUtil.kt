package com.diponnkar.rxjavamvvmhilt.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.diponnkar.rxjavamvvmhilt.R

object BindingAdapterUtil {

    @BindingAdapter("loadImage")
    @JvmStatic
    fun ImageView.loadImageFromUrl(url: String) {
        Glide
            .with(this.context)
            .load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(this)
    }
}