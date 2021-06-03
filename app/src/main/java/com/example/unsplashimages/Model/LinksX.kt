package com.example.unsplashimages.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LinksX(
    val download: String,
    val download_location: String,
    val html: String,
    val self: String
): Parcelable