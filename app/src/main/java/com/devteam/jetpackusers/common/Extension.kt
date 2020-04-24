package com.devteam.jetpackusers.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.devteam.jetpackusers.R

fun ImageView.loadImageByUrl(url: String?) {
    url?.let {
        Glide.with(this).load(url).placeholder(R.drawable.ic_loading_image_24).into(this)
    }
}