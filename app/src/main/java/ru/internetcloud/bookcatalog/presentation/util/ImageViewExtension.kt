package ru.internetcloud.bookcatalog.presentation.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(imageUri: String) {

    Glide.with(context)
        .load(imageUri)
        // .placeholder(R.drawable.ic_image)
        .into(this)
}
