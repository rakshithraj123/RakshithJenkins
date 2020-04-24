package com.devteam.jetpackusers.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("loadImage")
fun loadImage(imagView: ImageView, url: String?) {
    imagView.loadImageByUrl(url)
}