package com.example.unsplashimages.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UrlsX(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
): Parcelable